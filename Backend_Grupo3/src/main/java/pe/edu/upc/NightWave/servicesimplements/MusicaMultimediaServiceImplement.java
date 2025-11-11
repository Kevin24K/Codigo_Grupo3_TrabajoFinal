package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.MusicaMultimedia;
import pe.edu.upc.NightWave.repositories.IMusicaMultimediaRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IMusicaMultimediaService;

import java.util.List;

@Service
public class MusicaMultimediaServiceImplement implements IMusicaMultimediaService
{
    @Autowired
    private IMusicaMultimediaRepository mmR;

    @Override
    public void insert(MusicaMultimedia musicaMultimedia) {
        mmR.save(musicaMultimedia);
    }

    @Override
    public List<MusicaMultimedia> list() {
        return mmR.findAll();
    }

    @Override
    public void delete(int id) {
        mmR.deleteById(id);
    }

    @Override
    public MusicaMultimedia listId(int id) {
        return mmR.findById(id).orElse(null);
    }

    @Override
        public void update(MusicaMultimedia musicaMultimedia) {
        mmR.save(musicaMultimedia);
    }
}
