package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Sonido;

import java.util.List;

public interface ISonidoService {
    public List<Sonido> list();
    public void insert(Sonido sonido);
    public void delete(int id);
    public void update(Sonido sonido);
    public Sonido listId(int id);
}
