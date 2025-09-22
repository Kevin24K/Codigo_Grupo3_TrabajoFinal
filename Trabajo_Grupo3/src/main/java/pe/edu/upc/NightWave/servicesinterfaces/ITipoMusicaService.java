package pe.edu.upc.NightWave.servicesinterfaces;

import pe.edu.upc.NightWave.entities.TipoMusica;
import pe.edu.upc.NightWave.entities.Usuario;

import java.util.List;

public interface ITipoMusicaService
{
    public void insert(TipoMusica tipoMusica);
    public List<TipoMusica> list();
    public TipoMusica listId(int id);
    public void update(TipoMusica tipoMusica);
    public void delete(int id);
}
