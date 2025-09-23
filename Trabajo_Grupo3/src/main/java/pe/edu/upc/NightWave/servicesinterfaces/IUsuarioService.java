package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Usuario;

import java.util.List;


public interface IUsuarioService
{
    public void insert(Usuario usuario);
    public List<Usuario> list();
    public Usuario listId(int id);
    public void update(Usuario usuario);
    public void delete(int id);
    public List<Usuario> listarUsuariosPorRol(int rolId);
}
