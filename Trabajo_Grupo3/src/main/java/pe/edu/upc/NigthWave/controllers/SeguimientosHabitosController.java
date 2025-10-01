package pe.edu.upc.NigthWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.SeguimientoHabitosDTO;
import pe.edu.upc.NigthWave.entities.SeguimientoHabitos;
import pe.edu.upc.NigthWave.servicesinterfaces.ISeguimientoHabitosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seguimiento-habitos")
public class SeguimientosHabitosController {
    @Autowired
    private ISeguimientoHabitosService shS;

    private ModelMapper modelMapper = new ModelMapper();

    // Listar todos
    @GetMapping
    public ResponseEntity<?> listar() {
        List<SeguimientoHabitosDTO> lista = shS.list().stream()
                .map(s -> modelMapper.map(s, SeguimientoHabitosDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen registros de seguimiento de hábitos.");
        }

        return ResponseEntity.ok(lista);
    }

    // Listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        SeguimientoHabitos seguimiento = shS.listId(id);
        if (seguimiento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe seguimiento de hábito con ID: " + id);
        }
        SeguimientoHabitosDTO dto = modelMapper.map(seguimiento, SeguimientoHabitosDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Registrar
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody SeguimientoHabitosDTO dto) {
        SeguimientoHabitos seguimiento = modelMapper.map(dto, SeguimientoHabitos.class);
        shS.insert(seguimiento);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Seguimiento de hábito registrado correctamente.");
    }

    // Modificar
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody SeguimientoHabitosDTO dto) {
        SeguimientoHabitos existente = shS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe seguimiento de hábito con ID: " + dto.getId());
        }
        SeguimientoHabitos seguimiento = modelMapper.map(dto, SeguimientoHabitos.class);
        shS.update(seguimiento);
        return ResponseEntity.ok("Seguimiento de hábito con ID " + dto.getId() + " modificado correctamente.");
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        SeguimientoHabitos existente = shS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe seguimiento de hábito con ID: " + id);
        }
        shS.delete(id);
        return ResponseEntity.ok("Seguimiento de hábito con ID " + id + " eliminado correctamente.");
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
