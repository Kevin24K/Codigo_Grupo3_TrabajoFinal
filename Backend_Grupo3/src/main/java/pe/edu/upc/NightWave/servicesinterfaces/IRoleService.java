package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Role;

import java.util.List;


public interface IRoleService
{
    public List<Role> list();
    public void insert(Role rol);
    public void delete(int id);
    public void update(Role rol);
    public Role listId(int id);

}
