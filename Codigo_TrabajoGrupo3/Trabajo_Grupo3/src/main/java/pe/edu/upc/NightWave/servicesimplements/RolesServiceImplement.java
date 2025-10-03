package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Roles;
import pe.edu.upc.NightWave.repositories.IRolesRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IRolesService;

import java.util.List;

@Service
public class RolesServiceImplement implements IRolesService {

    @Autowired
    private IRolesRepository rR;

    @Override
    public List<Roles> list() {
        return rR.findAll();
    }

    @Override
    public Roles listId(Long id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public List<Roles> findByUserId(Long usuarioId) {
        return rR.findByUserId(usuarioId);
    }
}
