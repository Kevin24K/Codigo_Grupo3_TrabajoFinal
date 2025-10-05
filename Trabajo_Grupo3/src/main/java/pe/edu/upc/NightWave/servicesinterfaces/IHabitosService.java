package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Habitos;

import java.util.List;

public interface IHabitosService
{
    public void insert(Habitos habitos);
    public List<Habitos> list();
    public void delete(int id);
    public Habitos listId(int id);
    public void update(Habitos habitos);
}
