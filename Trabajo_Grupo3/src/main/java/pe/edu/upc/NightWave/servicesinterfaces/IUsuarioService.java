package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Usuario;

import java.util.List;


public interface IUsuarioService
{
    void insert(Usuario usuario);
    List<Usuario> list();
    Usuario listId(int id);
    void update(Usuario usuario);
    void delete(int id);
    List<Usuario> listByRolNombre(String nombreRol);
}
