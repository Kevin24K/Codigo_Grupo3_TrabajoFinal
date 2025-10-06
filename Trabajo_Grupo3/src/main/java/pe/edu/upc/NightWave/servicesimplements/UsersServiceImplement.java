package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Users;
import pe.edu.upc.NightWave.repositories.IUserRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Users findByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    public int buscarUsername(String nombre) {
        return userRepository.buscarUsername(nombre);
    }

    @Override
    public void insertarRol(String rol, Long userId) {
        userRepository.insRol(rol, userId);
    }

    @Override
    public List<Users> listarUsuarios() {
        return userRepository.findAll();
    }
}
