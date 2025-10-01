package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.Recompensas;

import java.util.List;

public interface IRecompensasService
{
    public void insert(Recompensas recompensas);
    public List<Recompensas> list();
    public void delete(int id);
    public Recompensas listId(int id);
    public void update(Recompensas recompensas);
    List<Recompensas> listarPorTipoRecompensa(String tipoRecompensa);
}
