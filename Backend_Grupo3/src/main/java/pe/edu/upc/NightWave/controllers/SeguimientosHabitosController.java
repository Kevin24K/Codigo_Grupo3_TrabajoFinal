package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.SeguimientoHabitosDTO;
import pe.edu.upc.NightWave.dtos.UsuariosConHabitosCompletadosDTO;
import pe.edu.upc.NightWave.dtos.UsuariosConHabitosNoCompletadosDTO;
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

    // Registrar un nuevo seguimiento
    @PostMapping("/registrar/{idHabito}/{idUsuario}")
    public ResponseEntity<String> registrar(@PathVariable("idHabito") int idHabito,
                                            @PathVariable("idUsuario") long idUsuario,
                                            @RequestBody SeguimientoHabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        SeguimientoHabitos sh = m.map(dto, SeguimientoHabitos.class);
        // Aquí puedes establecer los valores de idUsuario y idHabito en el objeto entity
        sh.getIdHabito().setIdHabitos(idHabito);
        sh.getIdUsuario().setId(idUsuario);
        shS.insert(sh);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Seguimiento registrado correctamente.");
    }

    // Listar los seguimientos de un hábito y usuario específicos
    @GetMapping("/listar/{idHabito}/{idUsuario}")
    public ResponseEntity<List<SeguimientoHabitosDTO>> listar(@PathVariable("idHabito") int idHabito,
                                                              @PathVariable("idUsuario") int idUsuario) {
        List<SeguimientoHabitosDTO> seguimientos = shS.list().stream()
                .filter(x -> x.getIdHabito().getIdHabitos() == idHabito && x.getIdUsuario().getId() == idUsuario)
                .map(x -> new ModelMapper().map(x, SeguimientoHabitosDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(seguimientos);
    }

    // Eliminar un seguimiento
    @DeleteMapping("/eliminar/{idHabito}/{idUsuario}/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("idHabito") int idHabito,
                                           @PathVariable("idUsuario") int idUsuario,
                                           @PathVariable("id") int id) {
        SeguimientoHabitos seguimiento = shS.listId(id);
        if (seguimiento == null || seguimiento.getIdHabito().getIdHabitos() != idHabito || seguimiento.getIdUsuario().getId() != idUsuario) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Seguimiento no encontrado");
        }
        shS.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Seguimiento eliminado correctamente");
    }

    // Obtener seguimiento por ID
    @GetMapping("/editar/{id}")
    public ResponseEntity<SeguimientoHabitosDTO> listarId(@PathVariable("id") int id) {
        SeguimientoHabitosDTO dto = new ModelMapper().map(shS.listId(id), SeguimientoHabitosDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Modificar un seguimiento
    @PutMapping("/editar/{idHabito}/{idUsuario}/{id}")
    public ResponseEntity<String> modificar(@PathVariable("idHabito") int idHabito,
                                            @PathVariable("idUsuario") long idUsuario,
                                            @RequestBody SeguimientoHabitosDTO dto) {
        SeguimientoHabitos sh = new ModelMapper().map(dto, SeguimientoHabitos.class);
        SeguimientoHabitos existente = shS.listId(dto.getIdSeguimientoHabitos());
        if (existente == null || existente.getIdHabito().getIdHabitos() != idHabito || existente.getIdUsuario().getId() != idUsuario) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe el seguimiento con ID: " + dto.getIdSeguimientoHabitos());
        }

        // Aquí puedes actualizar los valores del seguimiento si es necesario
        sh.getIdHabito().setIdHabitos(idHabito);
        sh.getIdUsuario().setId(idUsuario);
        shS.update(sh);
        return ResponseEntity.ok("Seguimiento con ID " + dto.getIdSeguimientoHabitos() + " modificado correctamente.");
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
