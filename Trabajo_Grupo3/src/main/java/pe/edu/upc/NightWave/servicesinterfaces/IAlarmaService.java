package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Alarma;
import java.util.List;

public interface IAlarmaService {
    void insert(Alarma alarma);
    List<Alarma> list();
    void delete(int id);
    Alarma listId(int id);
    void update(Alarma alarma);
}
