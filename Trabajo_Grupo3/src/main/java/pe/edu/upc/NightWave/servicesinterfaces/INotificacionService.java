package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.MusicaMultimedia;
import pe.edu.upc.NightWave.entities.Notificacion;

import java.util.List;

public interface INotificacionService
{
    public void insert(Notificacion notificacion);
    public List<Notificacion > list();
    public void delete(int id);
    public Notificacion  listId(int id);
    public void update(Notificacion notificacion);

}
