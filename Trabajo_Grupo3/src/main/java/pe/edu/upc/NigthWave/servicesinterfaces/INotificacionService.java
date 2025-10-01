package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.Notificacion;

import java.util.List;

public interface INotificacionService
{
    public void insert(Notificacion notificacion);
    public List<Notificacion > list();
    public void delete(int id);
    public Notificacion  listId(int id);
    public void update(Notificacion notificacion);

    List<Notificacion> findByUsuarioId(int usuarioId);
    List<Notificacion> findByUsuarioIdAndLeidaFalse(int usuarioId);
}
