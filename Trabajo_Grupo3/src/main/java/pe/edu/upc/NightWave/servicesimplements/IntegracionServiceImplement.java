package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Integraciones;
import pe.edu.upc.NightWave.repositories.IIntegracionesRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IIntegracionesService;

import java.util.List;

@Service
public class IntegracionServiceImplement implements IIntegracionesService
{
    @Autowired
    private IIntegracionesRepository iR;

    @Override
    public void insert(Integraciones integracion) {
        iR.save(integracion);
    }

    @Override
    public List<Integraciones> list() {
        return iR.findAll();
    }
}
