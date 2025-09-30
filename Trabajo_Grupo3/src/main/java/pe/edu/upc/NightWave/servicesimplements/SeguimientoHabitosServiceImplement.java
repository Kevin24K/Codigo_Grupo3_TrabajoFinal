package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.SeguimientoHabitos;
import pe.edu.upc.NightWave.repositories.ISeguimientoHabitosRepository;
import pe.edu.upc.NightWave.servicesinterfaces.ISeguimientoHabitosService;

import java.time.LocalDate;
import java.util.List;

@Service
public class SeguimientoHabitosServiceImplement implements ISeguimientoHabitosService {

    @Autowired
    private ISeguimientoHabitosRepository shR;

    @Override
    public void insert(SeguimientoHabitos seguimientoHabitos) {
        shR.save(seguimientoHabitos);
    }

    @Override
    public List<SeguimientoHabitos> list() {
        return shR.findAll();
    }

    @Override
    public void delete(int id) {
        shR.deleteById(id);
    }

    @Override
    public SeguimientoHabitos listId(int id) {
        return shR.findById(id).orElse(null);
    }

    @Override
    public void update(SeguimientoHabitos seguimientoHabitos) {
        shR.save(seguimientoHabitos);
    }


}
