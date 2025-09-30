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
@RequestMapping("/tipoMusica")
public class TipoMusicaController {
    @Autowired
    private ITipoMusicaService tmS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<TipoMusicaDTO> lista = tmS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TipoMusicaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen tipo de musica registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody TipoMusicaDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoMusica tm = m.map(dto, TipoMusica.class);
        tmS.insert(tm);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tipo musica registrado correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        TipoMusica tipoMusica = tmS.listId(id);
        if (tipoMusica == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe sueños con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TipoMusicaDTO dto = m.map(tipoMusica, TipoMusicaDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TipoMusicaDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoMusica tm = m.map(dto, TipoMusica.class);

        TipoMusica existente = tmS.listId(dto.getIdTipoMusica());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe tipo musica con ID: " + dto.getIdTipoMusica());
        }

        tmS.update(tm);
        return ResponseEntity.ok("Tipo musica con ID " + dto.getIdTipoMusica() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        TipoMusica tipoMusica = tmS.listId(id);
        if (tipoMusica == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un tipo musica con el ID: " + id);
        }
        tmS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

}
