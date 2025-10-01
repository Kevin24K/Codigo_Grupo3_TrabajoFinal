package pe.edu.upc.NigthWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NigthWave.entities.Habitos;
import pe.edu.upc.NigthWave.repositories.IHabitosRepository;
import pe.edu.upc.NigthWave.servicesinterfaces.IHabitosService;

import java.util.List;

@Service
public class HabitosServiceImplement implements IHabitosService
{
    @Autowired
    private IHabitosRepository hR;

    @Override
    public void insert(Habitos habitos) {
        hR.save(habitos);
    }

    @Override
    public List<Habitos> list() {
        return hR.findAll();
    }

    @Override
    public void delete(int id) {
        hR.deleteById(id);
    }

    @Override
    public Habitos listId(int id) {
        return hR.findById(id).orElse(null);
    }

    @Override
    public void update(Habitos habitos) {
        hR.save(habitos);
    }
}
