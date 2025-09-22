package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Recompensas;
import pe.edu.upc.NightWave.repositories.IRecompensasRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IRecompensasService;

import java.util.List;

@Service
public class RecompensasServiceImplement implements IRecompensasService
{
    @Autowired
    private IRecompensasRepository rR;


    @Override
    public void insert(Recompensas recompensas) {
        rR.save(recompensas);
    }

    @Override
    public List<Recompensas> list() {
        return rR.findAll();
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Recompensas listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Recompensas recompensas) {
        rR.save(recompensas);
    }

}
