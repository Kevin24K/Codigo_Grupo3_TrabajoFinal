package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Notificaciones;

import java.util.List;

public interface INotificacionesService {
    void insert(Notificaciones notificaciones);
    List<Notificaciones> list();
    void delete(int id);
    Notificaciones listId(int id);
    void update(Notificaciones notificaciones);

    List<Notificaciones> findByUsuarioId(int usuarioId);
    List<Notificaciones> findByUsuarioIdAndLeidaFalse(int usuarioId);
}
