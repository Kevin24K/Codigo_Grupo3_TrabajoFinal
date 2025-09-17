package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Integracion;
import java.util.List;

public interface IIntegracionService {
    void insert(Integracion integracion);
    List<Integracion> list();
    void delete(int id);
    Integracion listId(int id);
    public void update(Integracion integracion);
}
