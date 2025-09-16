package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Meditaciones;

import java.util.List;

public interface IMeditacionService
{
    public void insert(Meditaciones meditacion);
    public List<Meditaciones> list();
}
