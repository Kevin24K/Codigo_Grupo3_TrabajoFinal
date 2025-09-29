package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.ObjetivosRecompensas;

import java.util.List;

public interface IObjetivosRecompensasService
{
    public void insert(ObjetivosRecompensas objetivosRecompensas);
    public List<ObjetivosRecompensas> list();
    public void delete(int id);
    public ObjetivosRecompensas  listId(int id);
    public void update(ObjetivosRecompensas objetivosRecompensas);

    List<ObjetivosRecompensas> findByObjetivoId(int objetivoId);
    Long countByRecompensaId(int recompensaId);
}
