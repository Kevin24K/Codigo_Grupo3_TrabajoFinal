package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Sonido;
import pe.edu.upc.NightWave.repositories.ISonidoRepository;
import pe.edu.upc.NightWave.servicesinterfaces.ISonidoService;

import java.util.List;

@Service
public class SonidoServiceImplement implements ISonidoService {
    @Autowired
    private ISonidoRepository sR;

    @Override
    public List<Sonido> list() {
        return sR.findAll();
    }

    @Override
    public void insert(Sonido sonido) {
        sR.save(sonido);
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public void update(Sonido sonido) { sR.save(sonido);}

    @Override
    public Sonido listId(int id) {
        return sR.findById(id).orElse(null);
    }
}