package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Actividad;
import pe.edu.upc.NightWave.repositories.IActividadRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IActividadService;

import java.util.List;

@Service
public class ActividadServiceImplement implements IActividadService
{
    @Autowired
    private IActividadRepository aR;

    @Override
    public List<Actividad> list() {
        return aR.findAll();
    }

    @Override
    public void insert(Actividad actividad) {
        aR.save(actividad);
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public Actividad listId(int id) {
        return aR.findById(id).orElse(null);
    }

    @Override
    public void update(Actividad actividad) {
        aR.save(actividad);
    }
}

