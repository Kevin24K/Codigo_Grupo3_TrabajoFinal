package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Configuracion;
import pe.edu.upc.NightWave.repositories.IConfiguracionRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IConfiguracionService;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracionServiceImplement implements IConfiguracionService {

    @Autowired
    private IConfiguracionRepository cR;

    @Override
    public void insert(Configuracion configuracion) {
        cR.save(configuracion);
    }

    @Override
    public List<Configuracion> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public Configuracion listId(int id) {
        Optional<Configuracion> opt = cR.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void update(Configuracion configuracion) {
        cR.save(configuracion);
    }
}
