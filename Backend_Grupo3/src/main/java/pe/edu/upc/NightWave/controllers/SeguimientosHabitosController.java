package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.NotificacionDTO;
import pe.edu.upc.NightWave.dtos.SeguimientoHabitosDTO;
import pe.edu.upc.NightWave.dtos.UsuariosConHabitosCompletadosDTO;
import pe.edu.upc.NightWave.dtos.UsuariosConHabitosNoCompletadosDTO;
import pe.edu.upc.NightWave.entities.Notificacion;
import pe.edu.upc.NightWave.entities.SeguimientoHabitos;
import pe.edu.upc.NightWave.servicesinterfaces.ISeguimientoHabitosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seguimiento-habitos")
public class SeguimientosHabitosController {
    @Autowired
    private ISeguimientoHabitosService shS;

    //@PreAuthorize("hasAnyAuthority('coach','usuario','analista','admin')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody SeguimientoHabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        SeguimientoHabitos sh = m.map(dto, SeguimientoHabitos.class);
        shS.insert(sh);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Seguimiento registrado correctamente.");
    }

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping
    public List<SeguimientoHabitosDTO> listar() {
        return shS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SeguimientoHabitosDTO.class);
        }).collect(Collectors.toList());
    }

    //@PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        shS.delete(id);
    }

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping("/{id}")
    public SeguimientoHabitosDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(shS.listId(id), SeguimientoHabitosDTO.class);
    }

    //@PreAuthorize("hasAnyAuthority('coach','admin')")
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

    //@PreAuthorize("hasAuthority('admin')")
    @GetMapping("/habitoscompletadosPorUsuario")
    public ResponseEntity<?> habitoscompletadosPorUsuario() {
        List<UsuariosConHabitosCompletadosDTO> listaDto = new ArrayList<>();
        List<String[]> filas = shS.HabitosCompletadosPorUsuario();

        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        for (String[] x : filas) {
            UsuariosConHabitosCompletadosDTO dto = new UsuariosConHabitosCompletadosDTO();
            dto.setNombreHabito(x[0]);
            dto.setNombreUsuario(x[1]);
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }

    //@PreAuthorize("hasAuthority('admin')")
    @GetMapping("/habitosNocompletadosPorUsuario")
    public ResponseEntity<?> habitosNocompletadosPorUsuario() {
        List<UsuariosConHabitosNoCompletadosDTO> listaDto = new ArrayList<>();
        List<String[]> filas = shS.HabitosNoCompletadosPorUsuario();

        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        for (String[] x : filas) {
            UsuariosConHabitosNoCompletadosDTO dto = new UsuariosConHabitosNoCompletadosDTO();
            dto.setNombreHabito(x[0]);
            dto.setNombreUsuario(x[1]);
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }
}
