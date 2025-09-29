package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.SeguimientoHabitosDTO;
import pe.edu.upc.NightWave.entities.SeguimientoHabitos;
import pe.edu.upc.NightWave.entities.Usuario;
import pe.edu.upc.NightWave.servicesinterfaces.ISeguimientoHabitosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seguimiento-habitos")
public class SeguimientosHabitosController {
    @Autowired
    private ISeguimientoHabitosService shS;

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody SeguimientoHabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        SeguimientoHabitos sh = m.map(dto, SeguimientoHabitos.class);

        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        sh.setUsuario(usuario);

        shS.insert(sh);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.CREATED);
    }

    @GetMapping
    public List<SeguimientoHabitosDTO> listar() {
        return shS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SeguimientoHabitosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        shS.delete(id);
    }

    @GetMapping("/{id}")
    public SeguimientoHabitosDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(shS.listId(id), SeguimientoHabitosDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody SeguimientoHabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        SeguimientoHabitos sh = m.map(dto, SeguimientoHabitos.class);

        // Asignar el usuario
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        sh.setUsuario(usuario);

        shS.update(sh);
    }

    // Endpoint para la query personalizada: Seguimiento de hábitos por usuario
    @GetMapping("/por-usuario/{usuarioId}")
    public List<SeguimientoHabitosDTO> findByUsuarioId(@PathVariable("usuarioId") int usuarioId) {
        return shS.findByUsuarioId(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SeguimientoHabitosDTO.class);
        }).collect(Collectors.toList());
    }

    // Endpoint para la query personalizada: Hábitos completados por usuario
    @GetMapping("/por-usuario/completados/{usuarioId}")
    public List<SeguimientoHabitosDTO> findByUsuarioIdAndEstadoCumplimientoTrue(@PathVariable("usuarioId") int usuarioId) {
        return shS.findByUsuarioIdAndEstadoCumplimientoTrue(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SeguimientoHabitosDTO.class);
        }).collect(Collectors.toList());
    }
}
