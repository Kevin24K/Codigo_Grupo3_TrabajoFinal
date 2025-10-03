package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Notificaciones;
import pe.edu.upc.NightWave.repositories.INotificacionesRepository;
import pe.edu.upc.NightWave.servicesinterfaces.INotificacionesService;

import java.util.List;

@Service
public class NotificacionesServiceImplement implements INotificacionesService {

    @Autowired
    private INotificacionesRepository nR;

    @Override
    public void insert(Notificaciones notificaciones) {
        nR.save(notificaciones);
    }

    @Override
    public List<Notificaciones> list() {
        return nR.findAll();
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

    @Override
    public Notificaciones listId(int id) {
        return nR.findById(id).orElse(null);
    }

    @Override
    public void update(Notificaciones notificaciones) {
        nR.save(notificaciones);
    }

    @Override
    public List<Notificaciones> findByUsuarioId(int usuarioId) {
        return nR.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Notificaciones> findByUsuarioIdAndLeidaFalse(int usuarioId) {
        return nR.findByUsuarioIdAndLeidaFalse(usuarioId);
    }
}
