package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.AlarmaDTO;
import pe.edu.upc.NightWave.dtos.ObjetivosDTO;
import pe.edu.upc.NightWave.entities.Alarma;
import pe.edu.upc.NightWave.entities.Objetivos;
import pe.edu.upc.NightWave.servicesinterfaces.IAlarmaService;
import pe.edu.upc.NightWave.servicesinterfaces.IObjetivosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivos")
public class ObjetivosController {
    @Autowired
    private IObjetivosService oS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<ObjetivosDTO> lista = oS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObjetivosDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen objetivos registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ObjetivosDTO dto) {
        ModelMapper m = new ModelMapper();
        Objetivos o = m.map(dto, Objetivos.class);
        oS.insert(o);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Objetivo registrada correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Objetivos objetivos = oS.listId(id);
        if (objetivos == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe objetivo con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ObjetivosDTO dto = m.map(objetivos, ObjetivosDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ObjetivosDTO dto) {
        ModelMapper m = new ModelMapper();
        Objetivos ob = m.map(dto, Objetivos.class);

        Objetivos existente = oS.listId(dto.getIdObjetivos());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe objetivo con ID: " + dto.getIdObjetivos());
        }

        oS.update(ob);
        return ResponseEntity.ok("Objetivo con ID " + dto.getIdObjetivos() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Objetivos objetivos = oS.listId(id);
        if (objetivos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un objetivo con el ID: " + id);
        }
        oS.delete(id);
        return ResponseEntity.ok("Objetivo con ID " + id + " eliminado correctamente.");
    }

}
