package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Rol;
import pe.edu.upc.NightWave.entities.SeguimientoHabitos;

import java.util.List;

public interface ISeguimientoHabitosService
{
    public List<SeguimientoHabitos> list();
    public void insert(SeguimientoHabitos  seguimientoHabitos);
    public void delete(int id);
    public void update(SeguimientoHabitos  seguimientoHabitos);
    public SeguimientoHabitos listId(int id);
}
