package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ObjetivosDTO;
import pe.edu.upc.NightWave.entities.Objetivos;
import pe.edu.upc.NightWave.servicesinterfaces.IObjetivosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivos")
public class ObjetivosController {

    @Autowired
    private IObjetivosService oS;

    private ModelMapper modelMapper = new ModelMapper();

    // Listar todos
    @GetMapping
    public ResponseEntity<?> listar() {
        List<ObjetivosDTO> lista = oS.list().stream()
                .map(o -> modelMapper.map(o, ObjetivosDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen objetivos registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    // Listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Objetivos objetivo = oS.listId(id);
        if (objetivo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe objetivo con ID: " + id);
        }
        ObjetivosDTO dto = modelMapper.map(objetivo, ObjetivosDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Registrar
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ObjetivosDTO dto) {
        Objetivos objetivo = modelMapper.map(dto, Objetivos.class);
        oS.insert(objetivo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Objetivo registrado correctamente.");
    }

    // Modificar
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ObjetivosDTO dto) {
        Objetivos existente = oS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe objetivo con ID: " + dto.getId());
        }
        Objetivos objetivo = modelMapper.map(dto, Objetivos.class);
        oS.update(objetivo);
        return ResponseEntity.ok("Objetivo con ID " + dto.getId() + " modificado correctamente.");
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Objetivos existente = oS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe objetivo con ID: " + id);
        }
        oS.delete(id);
        return ResponseEntity.ok("Objetivo con ID " + id + " eliminado correctamente.");
    }
}
