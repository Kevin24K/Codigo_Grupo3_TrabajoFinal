package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Integracion;
import pe.edu.upc.NightWave.entities.Recompensas;

import java.util.List;

public interface IRecompensasService
{
    public void insert(Recompensas recompensas);
    public List<Recompensas> list();
    public void delete(int id);
    public Recompensas listId(int id);
    public void update(Recompensas recompensas);
}
