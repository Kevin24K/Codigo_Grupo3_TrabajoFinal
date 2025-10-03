package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.NightWave.dtos.RolesDTO;
import pe.edu.upc.NightWave.servicesinterfaces.IRolesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private IRolesService rS;

    @GetMapping
    public List<RolesDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RolesDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        return m.map(rS.listId(id), RolesDTO.class);
    }

    // Endpoint para la query personalizada: Roles de un usuario
    @GetMapping("/por-usuario/{usuarioId}")
    public List<RolesDTO> findByUserId(@PathVariable("usuarioId") Long userId) {
        return rS.findByUserId(userId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }
}
