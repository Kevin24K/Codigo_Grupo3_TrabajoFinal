package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Objetivos_Recompensas;
import pe.edu.upc.NightWave.repositories.IObjetivosRecompensasRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IObjetivosRecompensasService;

import java.util.List;

@Service
public class ObjetivosRecompensasServiceImplement implements IObjetivosRecompensasService {

    @Autowired
    private IObjetivosRecompensasRepository orR;

    @Override
    public void insert(Objetivos_Recompensas objetivosRecompensas) {
        orR.save(objetivosRecompensas);
    }

    @Override
    public List<Objetivos_Recompensas> list() {
        return orR.findAll();
    }

    @Override
    public void delete(int id) {
        orR.deleteById(id);
    }

    @Override
    public Objetivos_Recompensas listId(int id) {
        return orR.findById(id).orElse(null);
    }

    @Override
    public void update(Objetivos_Recompensas objetivosRecompensas) {
        orR.save(objetivosRecompensas);
    }

    @Override
    public List<Objetivos_Recompensas> findByObjetivoId(int objetivoId) {
        return orR.findByObjetivoId(objetivoId);
    }

    @Override
    public Long countByRecompensaId(int recompensaId) {
        return orR.countByRecompensaId(recompensaId);
    }
}
