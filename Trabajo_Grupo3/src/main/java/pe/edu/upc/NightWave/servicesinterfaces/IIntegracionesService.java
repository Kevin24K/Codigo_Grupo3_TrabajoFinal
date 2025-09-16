package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Integraciones;

import java.util.List;
public interface IIntegracionesService
{
    public void insert(Integraciones integracion);
    public List<Integraciones> list();
}
