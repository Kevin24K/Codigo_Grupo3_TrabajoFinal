package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Integracion;
import pe.edu.upc.NightWave.repositories.IIntegracionRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IIntegracionService;

import java.util.List;

@Service
public class IntegracionServiceImplement implements IIntegracionService {

    @Autowired
    private IIntegracionRepository iR;

    @Override
    public void insert(Integracion integracion) {
        iR.save(integracion);
    }

    @Override
    public List<Integracion> list() {
        return iR.findAll();
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public Integracion listId(int id) {
        return iR.findById(id).orElse(new Integracion());
    }

    @Override
    public void update(Integracion integracion) {
        iR.save(integracion);
    }
}
