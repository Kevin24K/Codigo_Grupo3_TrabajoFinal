package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Alarma;

import java.util.List;

public interface IAlarmaService
{
    public void insert(Alarma alarma);
    public List<Alarma> list();
    public void delete(int id);
    public Alarma listId(int id);
    public void update(Alarma alarma);
}
