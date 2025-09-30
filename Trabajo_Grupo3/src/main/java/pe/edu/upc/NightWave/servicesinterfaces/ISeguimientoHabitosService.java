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


}
