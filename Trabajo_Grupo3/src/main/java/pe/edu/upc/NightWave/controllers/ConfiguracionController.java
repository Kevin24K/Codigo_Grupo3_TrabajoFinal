package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ConfiguracionDTO;
import pe.edu.upc.NightWave.entities.Configuracion;
import pe.edu.upc.NightWave.servicesinterfaces.IConfiguracionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/configuracion")
public class ConfiguracionController {

    @Autowired
    private IConfiguracionService cS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<ConfiguracionDTO> lista = cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ConfiguracionDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen configuraciones registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Configuracion configuracion = cS.listId(id);
        if (configuracion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe configuración con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ConfiguracionDTO dto = m.map(configuracion, ConfiguracionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ConfiguracionDTO dto) {
        ModelMapper m = new ModelMapper();
        Configuracion c = m.map(dto, Configuracion.class);
        cS.insert(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Configuración registrada correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ConfiguracionDTO dto) {
        Configuracion existente = cS.listId(dto.getIdConfiguracion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe configuración con ID: " + dto.getIdConfiguracion());
        }
        ModelMapper m = new ModelMapper();
        Configuracion c = m.map(dto, Configuracion.class);
        cS.update(c);
        return ResponseEntity.ok("Configuración con ID " + dto.getIdConfiguracion() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Configuracion existente = cS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe configuración con ID: " + id);
        }
        cS.delete(id);
        return ResponseEntity.ok("Configuración con ID " + id + " eliminada correctamente.");
    }
}
