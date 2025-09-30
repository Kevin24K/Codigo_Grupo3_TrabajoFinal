package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ControlParentalDTO;
import pe.edu.upc.NightWave.dtos.EstresDTO;
import pe.edu.upc.NightWave.entities.ControlParental;
import pe.edu.upc.NightWave.entities.Estres;
import pe.edu.upc.NightWave.servicesinterfaces.IControlParentalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/control-parental")
public class ControlParentalController {

    @Autowired
    private IControlParentalService cpS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<ControlParentalDTO> lista = cpS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ControlParentalDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen registros de control parental.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ControlParentalDTO dto) {
        ModelMapper m = new ModelMapper();
        ControlParental controlParental = m.map(dto, ControlParental.class);
        cpS.insert(controlParental);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registro de control parental creado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        ControlParental controlParental = cpS.listId(id);
        if (controlParental == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de control parental con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ControlParentalDTO dto = m.map(controlParental, ControlParentalDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ControlParentalDTO dto) {
        ModelMapper m = new ModelMapper();
        ControlParental controlParental = m.map(dto, ControlParental.class);

        ControlParental existente = cpS.listId(dto.getIdControl());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe registro de control parental con ID: " + dto.getIdControl());
        }

        cpS.update(controlParental);
        return ResponseEntity.ok("Registro de control parental con ID " + dto.getIdControl() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        ControlParental controlParental = cpS.listId(id);
        if (controlParental == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de control parental con ID: " + id);
        }
        cpS.delete(id);
        return ResponseEntity.ok("Registro de control parental con ID " + id + " eliminado correctamente.");
    }
}
