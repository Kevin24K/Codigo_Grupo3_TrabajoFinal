package pe.edu.upc.NightWave.servicesinterfaces;

import java.util.List;


public interface IRolService
{
    public List<Rol> list();
    public void insert(Rol rol);
    public void delete(int id);
    public void update(Rol rol);
    public Rol listId(int id);

}
