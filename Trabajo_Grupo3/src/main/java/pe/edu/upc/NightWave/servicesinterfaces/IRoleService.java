package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.Rol;

import java.util.List;


public interface IRolService
{
    public List<Rol> list();
    public void insert(Rol rol);
    public void delete(int id);
    public void update(Rol rol);
    public Rol listId(int id);

}
