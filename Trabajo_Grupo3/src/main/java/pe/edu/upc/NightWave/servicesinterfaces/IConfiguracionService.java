package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Configuracion;
import java.util.List;

public interface IConfiguracionService {
    void insert(Configuracion configuracion);
    List<Configuracion> list();
    void delete(int id);
    Configuracion listId(int id);
    void update(Configuracion configuracion);
}
