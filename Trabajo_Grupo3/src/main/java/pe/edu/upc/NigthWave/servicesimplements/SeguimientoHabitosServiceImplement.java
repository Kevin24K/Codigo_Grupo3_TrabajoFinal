package pe.edu.upc.NigthWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NigthWave.entities.SeguimientoHabitos;
import pe.edu.upc.NigthWave.repositories.ISeguimientoHabitosRepository;
import pe.edu.upc.NigthWave.servicesinterfaces.ISeguimientoHabitosService;

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

    @Override
    public List<SeguimientoHabitos> findByUsuarioId(int usuarioId) {
        return shR.findByUsuarioId(usuarioId);
    }

    @Override
    public List<SeguimientoHabitos> findByUsuarioIdAndEstadoCumplimientoTrue(int usuarioId) {
        return shR.findByUsuarioIdAndEstadoCumplimientoTrue(usuarioId);
    }

    @Override
    public List<SeguimientoHabitos> findByUsuarioIdAndEstadoCumplimientoFalse(int usuarioId) {
        return shR.findByUsuarioIdAndEstadoCumplimientoFalse(usuarioId);
    }

    @Override
    public List<SeguimientoHabitos> findByUsuarioIdAndFechaRegistro(int usuarioId, LocalDate fecha) {
        return shR.findByUsuarioIdAndFechaRegistro(usuarioId, fecha);
    }
}
