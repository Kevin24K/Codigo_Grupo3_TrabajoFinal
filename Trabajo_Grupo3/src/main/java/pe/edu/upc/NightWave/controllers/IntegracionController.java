package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.IntegracionDTO;
import pe.edu.upc.NightWave.entities.Integracion;
import pe.edu.upc.NightWave.servicesinterfaces.IIntegracionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/integraciones")
public class IntegracionController {

    @Autowired
    private IIntegracionService iS;

    // Listar todas las integracion
    @GetMapping
    public ResponseEntity<?> listar() {
        List<IntegracionDTO> lista = iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IntegracionDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen dispositivos registrados.");
        }
        return ResponseEntity.ok(lista);
    }
    // Registrar nueva integración
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody IntegracionDTO dto) {
        ModelMapper m = new ModelMapper();
        Integracion i = m.map(dto, Integracion.class);
        iS.insert(i);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Dispositivo registrado correctamente.");
    }

    // Eliminar integración por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Integracion i = iS.listId(id);
        if (i == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        iS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    // Listar integración por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Integracion i = iS.listId(id);
        if (i == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        IntegracionDTO dto = m.map(i, IntegracionDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Modificar integración
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody IntegracionDTO dto) {
        ModelMapper m = new ModelMapper();
        Integracion i = m.map(dto, Integracion.class);

        Integracion existente = iS.listId(i.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + i.getId());
        }
        iS.update(i);
        return ResponseEntity.ok("Registro con ID " + i.getId() + " modificado correctamente.");
    }
}
