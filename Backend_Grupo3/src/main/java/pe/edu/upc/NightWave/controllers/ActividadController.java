package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ActividadDTO;
import pe.edu.upc.NightWave.entities.Actividad;
import pe.edu.upc.NightWave.servicesinterfaces.IActividadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private IActividadService aS;

    @PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<ActividadDTO> lista = aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ActividadDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen activiades registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @PreAuthorize("hasAnyAuthority('coach','usuario','analista','admin')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad a = m.map(dto, Actividad.class);
        aS.insert(a);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Actividad registrado correctamente.");
    }

    @PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Actividad actividad = aS.listId(id);
        if (actividad == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe actividades con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ActividadDTO dto = m.map(actividad, ActividadDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyAuthority('coach','admin')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);

        Actividad existente = aS.listId(dto.getIdActividad());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe actividad con ID: " + dto.getIdActividad());
        }

        aS.update(ac);
        return ResponseEntity.ok("Actividad con ID " + dto.getIdActividad() + " modificado correctamente.");
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Actividad actividad = aS.listId(id);
        if (actividad == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una actividad con el ID: " + id);
        }
        aS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}
