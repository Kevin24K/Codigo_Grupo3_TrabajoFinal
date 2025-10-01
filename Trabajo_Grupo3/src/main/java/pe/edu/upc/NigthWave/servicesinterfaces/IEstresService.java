package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.Estres;

import java.util.List;

public interface IEstresService
{
    public void insert(Estres estres);
    public List<Estres> list();
    public void delete(int id);
    public Estres listId(int id);
    public void update(Estres estres);
}
