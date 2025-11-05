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
    private IUserRepository uR;

    @Override
    public Users findByUsername(String username) {
        return uR.findOneByUsername(username);
    }

    @Override
    public int buscarUsername(String nombre) {
        return uR.buscarUsername(nombre);
    }

    @Override
    public void insertarRol(String rol, Long userId) {
        uR.insRol(rol, userId);
    }

    @Override
    public List<Users> listarUsuarios() {
        return uR.findAll();
    }

    @Override
    public void insert(Users usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public Users listId(long id) {
        return uR.findById(id).orElse(null);
    }

    @Override
    public void update(Users usuario) {
        uR.save(usuario);
    }

    @Override
    public void delete(long id) {
        uR.deleteById(id);
    }

}
