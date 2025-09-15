package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Usuario;

import java.util.List;


public interface IUsuarioService
{
    List<Usuario> listByRolNombre(String nombreRol);
}
