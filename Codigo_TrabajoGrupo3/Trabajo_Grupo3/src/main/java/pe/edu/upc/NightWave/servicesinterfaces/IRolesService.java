package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Roles;

import java.util.List;

public interface IRolesService {
    List<Roles> list();
    Roles listId(Long id);
    List<Roles> findByUserId(Long usuarioId);
}
