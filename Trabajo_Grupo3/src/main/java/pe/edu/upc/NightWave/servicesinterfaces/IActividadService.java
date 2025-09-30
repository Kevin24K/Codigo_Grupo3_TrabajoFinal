package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Actividad;

import java.util.List;

public interface IActividadService
{
    public void insert(Actividad actividad);
    public List<Actividad> list();
    public void delete(int id);
    public Actividad listId(int id);
    public void update(Actividad actividad);
}
