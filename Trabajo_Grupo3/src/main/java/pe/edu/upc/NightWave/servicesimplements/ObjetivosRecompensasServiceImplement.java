package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.ObjetivosRecompensas;
import pe.edu.upc.NightWave.repositories.IObjetivosRecompensasRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IObjetivosRecompensasService;

import java.util.List;

@Service
public class ObjetivosRecompensasServiceImplement implements IObjetivosRecompensasService
{
    @Autowired
    private IObjetivosRecompensasRepository orR;

    @Override
    public void insert(ObjetivosRecompensas objetivosRecompensas) {
        orR.save(objetivosRecompensas);
    }

    @Override
    public List<ObjetivosRecompensas> list() {
        return orR.findAll();
    }

    @Override
    public void delete(int id) {
        orR.deleteById(id);
    }

    @Override
    public ObjetivosRecompensas listId(int id) {
        return orR.findById(id).orElse(null);
    }

    @Override
    public void update(ObjetivosRecompensas objetivosRecompensas) {
        orR.save(objetivosRecompensas);
    }
}
