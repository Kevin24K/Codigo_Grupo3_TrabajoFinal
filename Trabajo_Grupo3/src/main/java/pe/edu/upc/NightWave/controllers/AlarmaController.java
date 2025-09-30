package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ActividadDTO;
import pe.edu.upc.NightWave.dtos.AlarmaDTO;
import pe.edu.upc.NightWave.entities.Actividad;
import pe.edu.upc.NightWave.entities.Alarma;
import pe.edu.upc.NightWave.servicesinterfaces.IActividadService;
import pe.edu.upc.NightWave.servicesinterfaces.IAlarmaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alarmas")
public class AlarmaController {
    @Autowired
    private IAlarmaService alS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<AlarmaDTO> lista = alS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlarmaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen alarmas registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody AlarmaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alarma al = m.map(dto, Alarma.class);
        alS.insert(al);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Alarma registrada correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Alarma alarma = alS.listId(id);
        if (alarma == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe alarma con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        AlarmaDTO dto = m.map(alarma, AlarmaDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody AlarmaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alarma al = m.map(dto, Alarma.class);

        Alarma existente = alS.listId(dto.getIdAlarma());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe alarma con ID: " + dto.getIdAlarma());
        }

        alS.update(al);
        return ResponseEntity.ok("Alarma con ID " + dto.getIdAlarma() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Alarma alarma = alS.listId(id);
        if (alarma == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una alarma con el ID: " + id);
        }
        alS.delete(id);
        return ResponseEntity.ok("Alarma con ID " + id + " eliminado correctamente.");
    }
}
