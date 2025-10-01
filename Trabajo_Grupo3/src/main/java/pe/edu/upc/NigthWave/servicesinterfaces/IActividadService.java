package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.Actividad;

import java.util.List;

public interface IActividadService
{
    public void insert(Actividad actividad);
    public List<Actividad> list();
    public void delete(int id);
    public Actividad listId(int id);
    public void update(Actividad actividad);
}
