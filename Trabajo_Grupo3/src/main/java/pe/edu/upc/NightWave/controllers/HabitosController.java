package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.AlarmaDTO;
import pe.edu.upc.NightWave.dtos.HabitosDTO;
import pe.edu.upc.NightWave.entities.Alarma;
import pe.edu.upc.NightWave.entities.Habitos;
import pe.edu.upc.NightWave.servicesinterfaces.IAlarmaService;
import pe.edu.upc.NightWave.servicesinterfaces.IHabitosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/habitos")
public class HabitosController {
    @Autowired
    private IHabitosService hS;

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

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody HabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        Habitos h = m.map(dto, Habitos.class);
        hS.insert(h);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Habito registrado correctamente.");
    }


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
}
