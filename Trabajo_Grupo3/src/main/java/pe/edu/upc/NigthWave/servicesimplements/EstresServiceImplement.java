package pe.edu.upc.NigthWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NigthWave.entities.Estres;
import pe.edu.upc.NigthWave.repositories.IEstresRepository;
import pe.edu.upc.NigthWave.servicesinterfaces.IEstresService;

import java.util.List;

@Service
public class EstresServiceImplement implements IEstresService
{
    @Autowired
    private IEstresRepository eR;

    @Override
    public void insert(Estres estres) {
        eR.save(estres);
    }

    @Override
    public List<Estres> list() {
        return eR.findAll();
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public Estres listId(int id) {
        return eR.findById(id).orElse(null);
    }

    @Override
    public void update(Estres estres) {
        eR.save(estres);
    }

}
