package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Usuario;
import pe.edu.upc.NightWave.repositories.IUsuarioRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IUsuarioService;

import java.util.List;
@Service
public class UsuarioServiceImplement implements IUsuarioService
{
    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> listByRolNombre(String nombreRol) {
        return uR.findByRolNombre(nombreRol);
    }

    @Override
    public void insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public Usuario listId(int id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void update(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }
}
