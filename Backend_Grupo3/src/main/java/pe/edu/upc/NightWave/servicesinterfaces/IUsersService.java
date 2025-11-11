package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Users;

import java.util.List;

public interface IUsersService {
    Users findByUsername(String username);
    int buscarUsername(String nombre);
    void insertarRol(String rol, Long userId);
    List<Users> listarUsuarios();

    public void insert(Users usuario);
    public List<Users> list();
    public Users listId(long id);
    public void update(Users usuario);
    public void delete(long id);
}
