package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Integracion;

import java.util.List;

public interface IIntegracionService {
    public void insert(Integracion integracion);
    public List<Integracion> list();
    public void delete(int id);
    public Integracion listId(int id);
    public void update(Integracion integracion);
}
