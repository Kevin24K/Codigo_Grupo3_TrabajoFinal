package pe.edu.upc.NigthWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.IntegracionDTO;
import pe.edu.upc.NigthWave.entities.Integracion;
import pe.edu.upc.NigthWave.servicesinterfaces.IIntegracionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/integraciones")
public class IntegracionController {

    @Autowired
    private IIntegracionService iS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<IntegracionDTO> lista = iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IntegracionDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen integraciones registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody IntegracionDTO dto) {
        ModelMapper m = new ModelMapper();
        Integracion integracion = m.map(dto, Integracion.class);
        iS.insert(integracion);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Integración registrada correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Integracion integracion = iS.listId(id);
        if (integracion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe integración con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        IntegracionDTO dto = m.map(integracion, IntegracionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody IntegracionDTO dto) {
        ModelMapper m = new ModelMapper();
        Integracion integracion = m.map(dto, Integracion.class);

        Integracion existente = iS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe integración con ID: " + dto.getId());
        }

        iS.update(integracion);
        return ResponseEntity.ok("Integración con ID " + dto.getId() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Integracion integracion = iS.listId(id);
        if (integracion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una integración con el ID: " + id);
        }
        iS.delete(id);
        return ResponseEntity.ok("Integración con ID " + id + " eliminada correctamente.");
    }
}
