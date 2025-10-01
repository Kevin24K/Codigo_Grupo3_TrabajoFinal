package pe.edu.upc.NigthWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.HabitosDTO;
import pe.edu.upc.NigthWave.entities.Habitos;
import pe.edu.upc.NigthWave.servicesinterfaces.IHabitosService;

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
                    .body("No existen hábitos registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody HabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        Habitos habito = m.map(dto, Habitos.class);
        hS.insert(habito);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Hábito registrado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Habitos habito = hS.listId(id);
        if (habito == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe hábito con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        HabitosDTO dto = m.map(habito, HabitosDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody HabitosDTO dto) {
        ModelMapper m = new ModelMapper();
        Habitos habito = m.map(dto, Habitos.class);

        Habitos existente = hS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe hábito con ID: " + dto.getId());
        }

        hS.update(habito);
        return ResponseEntity.ok("Hábito con ID " + dto.getId() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Habitos habito = hS.listId(id);
        if (habito == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un hábito con el ID: " + id);
        }
        hS.delete(id);
        return ResponseEntity.ok("Hábito con ID " + id + " eliminado correctamente.");
    }
}
