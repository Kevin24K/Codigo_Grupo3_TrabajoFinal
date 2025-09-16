package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Meditaciones;
import pe.edu.upc.NightWave.repositories.IMeditacionRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IMeditacionService;

import java.util.List;

@Service
public class MeditacionServiceImplement implements IMeditacionService
{
    @Autowired
    private IMeditacionRepository mR;

    @Override
    public void insert(Meditaciones meditacion) {
        mR.save(meditacion);
    }

    @Override
    public List<Meditaciones> list() {
        return mR.findAll();
    }
}
