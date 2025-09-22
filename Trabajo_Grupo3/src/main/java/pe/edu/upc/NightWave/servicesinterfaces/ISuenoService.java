package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.SeguimientoHabitos;
import pe.edu.upc.NightWave.entities.Sueno;

import java.util.List;

public interface ISuenoService
{
    public List<Sueno> list();
    public void insert(Sueno sueno);
    public void delete(int id);
    public void update(Sueno sueno);
    public Sueno listId(int id);
}
