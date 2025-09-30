package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.AlarmaDTO;
import pe.edu.upc.NightWave.dtos.EvaluacionDiariaDTO;
import pe.edu.upc.NightWave.entities.Alarma;
import pe.edu.upc.NightWave.entities.EvaluacionDiaria;
import pe.edu.upc.NightWave.servicesinterfaces.IAlarmaService;
import pe.edu.upc.NightWave.servicesinterfaces.IEvaluacionDiariaService;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/evaluacionesdiarias")
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
        EvaluacionDiaria ed = m.map(dto, EvaluacionDiaria.class);
        edS.insert(ed);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Evaluacion diaria registrada correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        EvaluacionDiaria evaluacionDiaria = edS.listId(id);
        if (evaluacionDiaria == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe evalucion diaria con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EvaluacionDiariaDTO dto = m.map(evaluacionDiaria, EvaluacionDiariaDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody EvaluacionDiariaDTO dto) {
        ModelMapper m = new ModelMapper();
        EvaluacionDiaria ed = m.map(dto, EvaluacionDiaria.class);

        EvaluacionDiaria existente = edS.listId(dto.getIdEvaluacionDiaria());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe evaluacion diaria con ID: " + dto.getIdEvaluacionDiaria());
        }

        edS.update(ed);
        return ResponseEntity.ok("Evaluacion diaria con ID " + dto.getIdEvaluacionDiaria() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        EvaluacionDiaria evaluacionDiaria = edS.listId(id);
        if (evaluacionDiaria == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una evaluacion diaria con el ID: " + id);
        }
        edS.delete(id);
        return ResponseEntity.ok("Evaluacion diaria con ID " + id + " eliminado correctamente.");
    }

}
