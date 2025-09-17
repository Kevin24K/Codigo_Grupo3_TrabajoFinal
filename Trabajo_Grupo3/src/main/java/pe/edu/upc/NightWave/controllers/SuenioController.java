package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.SuenioDTO;
import pe.edu.upc.NightWave.entities.Suenio;
import pe.edu.upc.NightWave.servicesinterfaces.ISuenioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suenios")
public class SuenioController {
    @Autowired
    private ISuenioService sS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<SuenioDTO> lista = sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SuenioDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen sueños registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody SuenioDTO dto) {
        ModelMapper m = new ModelMapper();
        Suenio s = m.map(dto, Suenio.class);
        sS.insert(s);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Sueño registrado correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Suenio suenio = sS.listId(id);
        if (suenio == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe sueños con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        SuenioDTO dto = m.map(suenio, SuenioDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody SuenioDTO dto) {
        ModelMapper m = new ModelMapper();
        Suenio su = m.map(dto, Suenio.class);

        Suenio existente = sS.listId(dto.getIdSuenio());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe notificaicones con ID: " + dto.getIdSuenio());
        }

        sS.update(su);
        return ResponseEntity.ok("Sueño con ID " + dto.getIdSuenio() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Suenio suenio = sS.listId(id);
        if (suenio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un sueño con el ID: " + id);
        }
        sS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}
