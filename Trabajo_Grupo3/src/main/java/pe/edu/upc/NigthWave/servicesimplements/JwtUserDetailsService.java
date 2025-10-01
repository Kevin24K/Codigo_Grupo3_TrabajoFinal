package pe.edu.upc.NigthWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.NigthWave.entities.Usuario;
import pe.edu.upc.NigthWave.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findOneByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("El usuario no existe: " + username);
        }

        // Cargar roles como GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        // Crear objeto UserDetails de Spring Security
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isActivo(),   // enabaled
                true,              // accountNonExpired
                true,              // credentialsNonExpired
                true,              // accountNonLocked
                authorities
        );
    }
}
