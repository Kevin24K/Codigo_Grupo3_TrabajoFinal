package pe.edu.upc.NigthWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NigthWave.entities.Objetivos;
import pe.edu.upc.NigthWave.repositories.IObjetivosRepository;
import pe.edu.upc.NigthWave.servicesinterfaces.IObjetivosService;

import java.util.List;

@Service
public class ObjetivosServiceImplement implements IObjetivosService
{
    @Autowired
    private IObjetivosRepository oR;


    @Override
    public void insert(Objetivos  objetivos) {
        oR.save(objetivos);
    }

    @Override
    public List<Objetivos> list() {
        return oR.findAll();
    }

    @Override
    public void delete(int id) {
        oR.deleteById(id);
    }

    @Override
    public Objetivos listId(int id) {
        return oR.findById(id).orElse(null);
    }

    @Override
    public void update(Objetivos  objetivos) {
        oR.save(objetivos);
    }
}
