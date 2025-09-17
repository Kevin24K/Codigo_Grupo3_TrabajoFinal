package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Rol;
import pe.edu.upc.NightWave.repositories.IRolRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IRolService;

import java.util.List;
@Service
public class RolServiceImplement implements IRolService
{
    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Rol listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }
}
