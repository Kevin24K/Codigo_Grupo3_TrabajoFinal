package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Users;

import java.util.List;

public interface IUsersService {
    Users findByUsername(String username);
    int buscarUsername(String nombre);
    void insertarRol(String rol, Long userId);
    List<Users> listarUsuarios();
}
