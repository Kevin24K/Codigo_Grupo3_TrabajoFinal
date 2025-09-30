package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ObjetivosRecompensasDTO;
import pe.edu.upc.NightWave.entities.Objetivos;
import pe.edu.upc.NightWave.entities.ObjetivosRecompensas;
import pe.edu.upc.NightWave.entities.Recompensas;
import pe.edu.upc.NightWave.servicesinterfaces.IObjetivosRecompensasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivosrecompensas")
public class ObjetivosRecompensasController {
    @Autowired
    private IObjetivosRecompensasService orS;

    private ModelMapper modelMapper = new ModelMapper();

    // Listar todos
    @GetMapping
    public ResponseEntity<?> listar() {
        List<ObjetivosRecompensasDTO> lista = orS.list().stream()
                .map(o -> modelMapper.map(o, ObjetivosRecompensasDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen registros de objetivos y recompensas.");
        }

        return ResponseEntity.ok(lista);
    }

    // Listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        ObjetivosRecompensas objRec = orS.listId(id);
        if (objRec == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de objetivo-recompensa con ID: " + id);
        }
        ObjetivosRecompensasDTO dto = modelMapper.map(objRec, ObjetivosRecompensasDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Registrar
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ObjetivosRecompensasDTO dto) {
        ObjetivosRecompensas objRec = modelMapper.map(dto, ObjetivosRecompensas.class);
        orS.insert(objRec);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registro de objetivo-recompensa creado correctamente.");
    }

    // Modificar
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ObjetivosRecompensasDTO dto) {
        ObjetivosRecompensas existente = orS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe registro de objetivo-recompensa con ID: " + dto.getId());
        }
        ObjetivosRecompensas objRec = modelMapper.map(dto, ObjetivosRecompensas.class);
        orS.update(objRec);
        return ResponseEntity.ok("Registro de objetivo-recompensa con ID " + dto.getId() + " modificado correctamente.");
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        ObjetivosRecompensas existente = orS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de objetivo-recompensa con ID: " + id);
        }
        orS.delete(id);
        return ResponseEntity.ok("Registro de objetivo-recompensa con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/por-objetivo/{idObjetivo}")
    public List<ObjetivosRecompensasDTO> findByObjetivoId(@PathVariable("idObjetivo") int objetivoId) {
        return orS.findByObjetivoId(objetivoId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObjetivosRecompensasDTO.class);
        }).collect(Collectors.toList());
    }
}
