package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.NotificacionDTO;
import pe.edu.upc.NightWave.dtos.SeguimientoHabitosDTO;
import pe.edu.upc.NightWave.entities.Notificacion;
import pe.edu.upc.NightWave.entities.SeguimientoHabitos;
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
        shS.insert(sh);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Seguimiento registrado correctamente.");
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
    public ResponseEntity<String> modificar(@RequestBody SeguimientoHabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        SeguimientoHabitos sh = m.map(dto, SeguimientoHabitos.class);

        SeguimientoHabitos existente = shS.listId(dto.getIdSeguimientoHabitos());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe notificaicones con ID: " + dto.getIdSeguimientoHabitos());
        }

        shS.update(sh);
        return ResponseEntity.ok("Control parental con ID " + dto.getIdSeguimientoHabitos() + " modificado correctamente.");
    }


}
