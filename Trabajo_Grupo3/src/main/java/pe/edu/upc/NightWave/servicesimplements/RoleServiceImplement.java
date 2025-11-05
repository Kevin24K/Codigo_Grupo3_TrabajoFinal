package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Role;
import pe.edu.upc.NightWave.repositories.IRoleRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IRoleService;


import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService
{
    @Autowired
    private IRoleRepository rR;

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Role rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Role listId(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Role rol) {
        rR.save(rol);
    }
}
