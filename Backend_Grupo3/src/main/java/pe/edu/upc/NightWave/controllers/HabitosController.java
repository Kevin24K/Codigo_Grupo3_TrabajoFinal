package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.*;
import pe.edu.upc.NightWave.entities.Alarma;
import pe.edu.upc.NightWave.entities.Habitos;
import pe.edu.upc.NightWave.servicesinterfaces.IAlarmaService;
import pe.edu.upc.NightWave.servicesinterfaces.IHabitosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/habitos")
public class HabitosController {
    @Autowired
    private IHabitosService hS;

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping
    public ResponseEntity<?> listar() { 
        List<HabitosDTO> lista = hS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, HabitosDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen habitos registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    //@PreAuthorize("hasAnyAuthority('coach','usuario','analista','admin')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody HabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        Habitos h = m.map(dto, Habitos.class);
        hS.insert(h);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Habito registrado correctamente.");
    }

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Habitos habitos = hS.listId(id);
        if (habitos == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe habito con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        HabitosDTO dto = m.map(habitos, HabitosDTO.class);
        return ResponseEntity.ok(dto);
    }

    //@PreAuthorize("hasAnyAuthority('coach','admin')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody HabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        Habitos h = m.map(dto, Habitos.class);

        Habitos existente = hS.listId(dto.getIdHabitos());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe habito con ID: " + dto.getIdHabitos());
        }

        hS.update(h);
        return ResponseEntity.ok("Habito con ID " + dto.getIdHabitos() + " modificado correctamente.");
    }

    //@PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Habitos habitos = hS.listId(id);
        if (habitos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un habito con el ID: " + id);
        }
        hS.delete(id);
        return ResponseEntity.ok("Habito con ID " + id + " eliminado correctamente.");
    }

    //@PreAuthorize("hasAuthority('admin')")
    @GetMapping("/HabitosActivosporUsuario")
    public ResponseEntity<?> habitosNocompletadosPorUsuario(@RequestParam("id") Long id) {
        List<HabitosActivosPorUsuarioDTO> listaDto = new ArrayList<>();
        List<String[]> filas = hS.HabitosActivosParaUnUsuario(id);

        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        for (String[] x : filas) {
            HabitosActivosPorUsuarioDTO dto = new HabitosActivosPorUsuarioDTO();
            dto.setNombreHabito(x[0]);
            dto.setNombreUsuario(x[1]);
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }
}
