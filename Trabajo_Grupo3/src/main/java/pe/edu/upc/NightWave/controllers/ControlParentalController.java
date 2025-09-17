package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ControlParentalDTO;
import pe.edu.upc.NightWave.entities.ControlParental;
import pe.edu.upc.NightWave.servicesinterfaces.IControlParentalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/control-parental")
public class ControlParentalController {

    @Autowired
    private IControlParentalService crpS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<ControlParentalDTO> lista = crpS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ControlParentalDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No existen controles parentales registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        ControlParental crp = crpS.listId(id);
        if (crp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe control parental con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ControlParentalDTO dto = m.map(crp, ControlParentalDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ControlParentalDTO dto) {
        ModelMapper m = new ModelMapper();
        ControlParental crp = m.map(dto, ControlParental.class);
        crpS.insert(crp);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Control parental registrado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ControlParentalDTO dto) {
        ControlParental existente = crpS.listId(dto.getIdControl());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe control parental con ID: " + dto.getIdControl());
        }
        ModelMapper m = new ModelMapper();
        ControlParental crp = m.map(dto, ControlParental.class);
        crpS.update(crp);
        return ResponseEntity.ok("Control parental con ID " + dto.getIdControl() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        ControlParental existente = crpS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe control parental con ID: " + id);
        }
        crpS.delete(id);
        return ResponseEntity.ok("Control parental con ID " + id + " eliminado correctamente.");
    }
}
