package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.TipoMusicaDTO;
import pe.edu.upc.NightWave.entities.TipoMusica;
import pe.edu.upc.NightWave.servicesinterfaces.ITipoMusicaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiposmusica")
public class TipoMusicaController {

    @Autowired
    private ITipoMusicaService tmS;

    private ModelMapper modelMapper = new ModelMapper();

    // Listar todos
    @GetMapping
    public ResponseEntity<?> listar() {
        List<TipoMusicaDTO> lista = tmS.list().stream()
                .map(t -> modelMapper.map(t, TipoMusicaDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen tipos de música registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    // Listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        TipoMusica tipo = tmS.listId(id);
        if (tipo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe tipo de música con ID: " + id);
        }
        TipoMusicaDTO dto = modelMapper.map(tipo, TipoMusicaDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Registrar
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody TipoMusicaDTO dto) {
        TipoMusica tipo = modelMapper.map(dto, TipoMusica.class);
        tmS.insert(tipo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tipo de música registrado correctamente.");
    }

    // Modificar
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TipoMusicaDTO dto) {
        TipoMusica existente = tmS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe tipo de música con ID: " + dto.getId());
        }
        TipoMusica tipo = modelMapper.map(dto, TipoMusica.class);
        tmS.update(tipo);
        return ResponseEntity.ok("Tipo de música con ID " + dto.getId() + " modificado correctamente.");
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        TipoMusica existente = tmS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe tipo de música con ID: " + id);
        }
        tmS.delete(id);
        return ResponseEntity.ok("Tipo de música con ID " + id + " eliminado correctamente.");
    }
}
