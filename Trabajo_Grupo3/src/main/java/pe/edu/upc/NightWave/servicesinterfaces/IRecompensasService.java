package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Integracion;
import pe.edu.upc.NightWave.entities.Recompensas;

import java.util.List;

public interface IRecompensasService
{
    void insert(Recompensas recompensas);
    List<Recompensas> list();
    void delete(int id);
    Recompensas listId(int id);
    public void update(Recompensas recompensas);
}
