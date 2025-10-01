package pe.edu.upc.NigthWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.AlarmaDTO;
import pe.edu.upc.NigthWave.entities.Alarma;
import pe.edu.upc.NigthWave.servicesinterfaces.IAlarmaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alarmas")
public class AlarmaController {

    @Autowired
    private IAlarmaService aS;

    private final ModelMapper modelMapper = new ModelMapper();

    // Listar todas las alarmas
    @GetMapping
    public ResponseEntity<?> listar() {
        List<AlarmaDTO> lista = aS.list().stream()
                .map(x -> modelMapper.map(x, AlarmaDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen alarmas registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    // Registrar nueva alarma
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody AlarmaDTO dto) {
        Alarma alarma = modelMapper.map(dto, Alarma.class);
        aS.insert(alarma);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Alarma registrada correctamente.");
    }

    // Listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Alarma alarma = aS.listId(id);
        if (alarma == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una alarma con ID: " + id);
        }
        AlarmaDTO dto = modelMapper.map(alarma, AlarmaDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Modificar alarma
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody AlarmaDTO dto) {
        Alarma existente = aS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una alarma con ID: " + dto.getId());
        }
        Alarma alarma = modelMapper.map(dto, Alarma.class);
        aS.update(alarma);
        return ResponseEntity.ok("Alarma con ID " + dto.getId() + " modificada correctamente.");
    }

    // Eliminar alarma
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Alarma existente = aS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una alarma con ID: " + id);
        }
        aS.delete(id);
        return ResponseEntity.ok("Alarma con ID " + id + " eliminada correctamente.");
    }
}
