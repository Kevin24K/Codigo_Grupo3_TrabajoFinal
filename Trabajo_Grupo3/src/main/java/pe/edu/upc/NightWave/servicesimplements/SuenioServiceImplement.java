package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Suenio;
import pe.edu.upc.NightWave.repositories.ISuenioRepository;
import pe.edu.upc.NightWave.servicesinterfaces.ISuenioService;

import java.util.List;

@Service
public class SuenioServiceImplement implements ISuenioService {

    @Autowired
    private ISuenioRepository sR;

    @Override
    public void insert(Suenio suenio) {
        sR.save(suenio);
    }

    @Override
    public List<Suenio> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public Suenio listId(int id) {
        return sR.findById(id).orElse(null);
    }

    @Override
    public void update(Suenio suenio) {
        sR.save(suenio);
    }
}
