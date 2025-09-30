package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.EstresDTO;
import pe.edu.upc.NightWave.entities.Estres;
import pe.edu.upc.NightWave.servicesinterfaces.IEstresService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estres")
public class EstresController {

    @Autowired
    private IEstresService eS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<EstresDTO> lista = eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EstresDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen registros de estrés.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody EstresDTO dto) {
        ModelMapper m = new ModelMapper();
        Estres estres = m.map(dto, Estres.class);
        eS.insert(estres);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registro de estrés creado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Estres estres = eS.listId(id);
        if (estres == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de estrés con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EstresDTO dto = m.map(estres, EstresDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody EstresDTO dto) {
        ModelMapper m = new ModelMapper();
        Estres estres = m.map(dto, Estres.class);

        Estres existente = eS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe registro de estrés con ID: " + dto.getId());
        }

        eS.update(estres);
        return ResponseEntity.ok("Registro de estrés con ID " + dto.getId() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Estres estres = eS.listId(id);
        if (estres == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe registro de estrés con ID: " + id);
        }
        eS.delete(id);
        return ResponseEntity.ok("Registro de estrés con ID " + id + " eliminado correctamente.");
    }
}
