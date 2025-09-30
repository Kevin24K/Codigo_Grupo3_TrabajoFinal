package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.EvaluacionDiariaDTO;
import pe.edu.upc.NightWave.entities.EvaluacionDiaria;
import pe.edu.upc.NightWave.servicesinterfaces.IEvaluacionDiariaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evaluacionesDiarias")
public class EvaluacionDiariaController {

    @Autowired
    private IEvaluacionDiariaService edS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<EvaluacionDiariaDTO> lista = edS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EvaluacionDiariaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen evaluaciones diarias registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody EvaluacionDiariaDTO dto) {
        ModelMapper m = new ModelMapper();
        EvaluacionDiaria evaluacion = m.map(dto, EvaluacionDiaria.class);
        edS.insert(evaluacion);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Evaluación diaria registrada correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        EvaluacionDiaria evaluacion = edS.listId(id);
        if (evaluacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe evaluación diaria con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EvaluacionDiariaDTO dto = m.map(evaluacion, EvaluacionDiariaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody EvaluacionDiariaDTO dto) {
        ModelMapper m = new ModelMapper();
        EvaluacionDiaria evaluacion = m.map(dto, EvaluacionDiaria.class);

        EvaluacionDiaria existente = edS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe evaluación diaria con ID: " + dto.getId());
        }

        edS.update(evaluacion);
        return ResponseEntity.ok("Evaluación diaria con ID " + dto.getId() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        EvaluacionDiaria evaluacion = edS.listId(id);
        if (evaluacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una evaluación diaria con el ID: " + id);
        }
        edS.delete(id);
        return ResponseEntity.ok("Evaluación diaria con ID " + id + " eliminada correctamente.");
    }
}
