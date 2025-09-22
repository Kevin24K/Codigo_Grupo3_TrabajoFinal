package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Sueno;
import pe.edu.upc.NightWave.repositories.ISuenoRepository;
import pe.edu.upc.NightWave.servicesinterfaces.ISuenoService;

import java.util.List;

@Service
public class SuenoServiceImplement implements ISuenoService
{
    @Autowired
    private ISuenoRepository sR;

    @Override
    public void insert(Sueno sueno) {
        sR.save(sueno);
    }

    @Override
    public List<Sueno> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public Sueno listId(int id) {
        return sR.findById(id).orElse(null);
    }

    @Override
    public void update(Sueno sueno) {
        sR.save(sueno);
    }
}
