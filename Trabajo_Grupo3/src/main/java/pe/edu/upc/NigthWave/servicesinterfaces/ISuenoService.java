package pe.edu.upc.NigthWave.servicesinterfaces;

import pe.edu.upc.NigthWave.entities.Sueno;

import java.util.List;

public interface ISuenoService
{
    public List<Sueno> list();
    public void insert(Sueno sueno);
    public void delete(int id);
    public void update(Sueno sueno);
    public Sueno listId(int id);
    List<Sueno> BuscarPorCalidadDeSueno(int calidadSueno);
    Double promedioHorasDormidasPorUsuario(int usuarioId);
    List<Object[]> promedioHorasDormidasTodosUsuarios();
    Object[] relacionEstresCalidadPorUsuario(int usuarioId);
}
