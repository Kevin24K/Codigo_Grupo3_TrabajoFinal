package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.Objetivos;

import java.util.List;

public interface IObjetivosService
{
    public  void insert(Objetivos objetivos);
    public List<Objetivos> list();
    public void delete(int id);
    public Objetivos  listId(int id);
    public void update(Objetivos objetivos);
}
