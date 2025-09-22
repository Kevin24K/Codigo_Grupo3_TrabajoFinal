package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.ControlParental;
import pe.edu.upc.NightWave.repositories.IControlParentalRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IControlParentalService;

import java.util.List;

@Service
public class ControlParentalServiceImplement implements IControlParentalService {

    @Autowired
    private IControlParentalRepository cpR;

    @Override
    public void insert(ControlParental controlParental) {
        cpR.save(controlParental);
    }

    @Override
    public List<ControlParental> list() {
        return cpR.findAll();
    }

    @Override
    public void delete(int id) {
        cpR.deleteById(id);
    }

    @Override
    public ControlParental listId(int id) {
        return cpR.findById(id).orElse(null);
    }

    @Override
    public void update(ControlParental controlParental) {
        cpR.save(controlParental);
    }
}
