package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.SeguimientoHabitos;

import java.time.LocalDate;
import java.util.List;

public interface ISeguimientoHabitosService {
    void insert(SeguimientoHabitos seguimientoHabitos);
    List<SeguimientoHabitos> list();
    void delete(int id);
    SeguimientoHabitos listId(int id);
    void update(SeguimientoHabitos seguimientoHabitos);

    List<SeguimientoHabitos> findByUsuarioId(int usuarioId);
    List<SeguimientoHabitos> findByUsuarioIdAndEstadoCumplimientoTrue(int usuarioId);
    List<SeguimientoHabitos> findByUsuarioIdAndEstadoCumplimientoFalse(int usuarioId);
    List<SeguimientoHabitos> findByUsuarioIdAndFechaRegistro(int usuarioId, LocalDate fecha);
}
