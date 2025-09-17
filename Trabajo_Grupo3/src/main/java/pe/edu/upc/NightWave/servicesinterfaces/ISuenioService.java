package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Suenio;

import java.util.List;

public interface ISuenioService {
    public void insert(Suenio suenio);
    public List<Suenio> list();
    public void delete(int id);
    public Suenio listId(int id);
    public void update(Suenio suenio);
}
