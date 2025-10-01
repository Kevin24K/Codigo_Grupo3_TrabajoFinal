package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.Alarma;

import java.util.List;

public interface IAlarmaService
{
    public void insert(Alarma alarma);
    public List<Alarma> list();
    public void delete(int id);
    public Alarma listId(int id);
    public void update(Alarma alarma);
}
