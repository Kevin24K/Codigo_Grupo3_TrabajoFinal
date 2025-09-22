package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Notificacion;
import pe.edu.upc.NightWave.repositories.INotificacionRepository;
import pe.edu.upc.NightWave.servicesinterfaces.INotificacionService;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService
{
    @Autowired
    private INotificacionRepository nR;

    @Override
    public void insert(Notificacion notificacion) {
        nR.save(notificacion);
    }

    @Override
    public List<Notificacion> list() {
        return nR.findAll();
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

    @Override
    public Notificacion listId(int id) {
        return nR.findById(id).orElse(null);
    }

    @Override
    public void update(Notificacion notificacion) {
        nR.save(notificacion);
    }
}
