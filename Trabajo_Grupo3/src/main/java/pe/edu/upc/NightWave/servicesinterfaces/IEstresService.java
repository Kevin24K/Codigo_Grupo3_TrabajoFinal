package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.Estres;

import java.util.List;

public interface IEstresService
{
    public void insert(Estres estres);
    public List<Estres> list();
    public void delete(int id);
    public Estres listId(int id);
    public void update(Estres estres);
    //Query
    public List<String[]> promedioEstresYAnsiedadPorUsuario();
    //Query
    public List<String[]> conteoEstresPorMes();
}
