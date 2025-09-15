package pe.edu.upc.NightWave.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.NightWave.entities.Usuario;
import pe.edu.upc.NightWave.repositories.IUsuarioRepository;
import pe.edu.upc.NightWave.servicesinterfaces.IUsuarioService;

import java.util.List;
@Service
public class UsuarioServiceImplement implements IUsuarioService
{
    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> listByRolNombre(String nombreRol) {
        return uR.findByRolNombre(nombreRol);
    }
}
