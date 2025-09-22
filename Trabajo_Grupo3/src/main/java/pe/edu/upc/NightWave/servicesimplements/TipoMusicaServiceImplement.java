package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.TipoMusica;
import pe.edu.upc.NightWave.repositories.ITipoMusicaRepository;
import pe.edu.upc.NightWave.servicesinterfaces.ITipoMusicaService;

import java.util.List;

@Service
public class TipoMusicaServiceImplement implements ITipoMusicaService
{
    @Autowired
    private ITipoMusicaRepository tmR;

    @Override
    public void insert(TipoMusica tipoMusica) {
        tmR.save(tipoMusica);
    }

    @Override
    public List<TipoMusica> list() {
        return tmR.findAll();
    }

    @Override
    public TipoMusica listId(int id) {
        return tmR.findById(id).orElse(null);
    }

    @Override
    public void update(TipoMusica tipoMusica) {
        tmR.save(tipoMusica);
    }

    @Override
    public void delete(int id) {
        tmR.deleteById(id);
    }
}
