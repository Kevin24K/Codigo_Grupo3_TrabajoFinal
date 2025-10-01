package pe.edu.upc.NigthWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.ActividadDTO;
import pe.edu.upc.NigthWave.entities.Actividad;
import pe.edu.upc.NigthWave.servicesinterfaces.IActividadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private IActividadService actS;

    private final ModelMapper modelMapper = new ModelMapper();

    // Listar todas las actividades
    @GetMapping
    public ResponseEntity<?> listar() {
        List<ActividadDTO> lista = actS.list().stream()
                .map(x -> modelMapper.map(x, ActividadDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen actividades registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    // Registrar nueva actividad
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ActividadDTO dto) {
        Actividad actividad = modelMapper.map(dto, Actividad.class);
        actS.insert(actividad);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Actividad registrada correctamente.");
    }

    // Listar actividad por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Actividad actividad = actS.listId(id);
        if (actividad == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una actividad con ID: " + id);
        }
        ActividadDTO dto = modelMapper.map(actividad, ActividadDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Modificar actividad
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ActividadDTO dto) {
        Actividad existente = actS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una actividad con ID: " + dto.getId());
        }
        Actividad actividad = modelMapper.map(dto, Actividad.class);
        actS.update(actividad);
        return ResponseEntity.ok("Actividad con ID " + dto.getId() + " modificada correctamente.");
    }

    // Eliminar actividad
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Actividad existente = actS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una actividad con ID: " + id);
        }
        actS.delete(id);
        return ResponseEntity.ok("Actividad con ID " + id + " eliminada correctamente.");
    }
}
