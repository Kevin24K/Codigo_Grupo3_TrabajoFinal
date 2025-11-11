package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Alarma;
import pe.edu.upc.NightWave.repositories.IAlarmaRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IAlarmaService;

import java.util.List;

@Service
public class AlarmaServiceImplement implements IAlarmaService
{
    @Autowired
    private IAlarmaRepository aR;

    @Override
    public List<Alarma> list() {
        return aR.findAll();
    }

    @Override
    public void insert(Alarma alarma) {
        aR.save(alarma);
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public Alarma listId(int id) {
        return aR.findById(id).orElse(null);
    }

    @Override
    public void update(Alarma alarma) {
        aR.save(alarma);
    }
}
