package pe.edu.upc.NigthWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.MusicaMultimediaDTO;
import pe.edu.upc.NigthWave.entities.MusicaMultimedia;
import pe.edu.upc.NigthWave.servicesinterfaces.IMusicaMultimediaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/musicaMultimedia")
public class MusicaMultimediaController {

    @Autowired
    private IMusicaMultimediaService mmS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<MusicaMultimediaDTO> lista = mmS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MusicaMultimediaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen musicas registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody MusicaMultimediaDTO dto) {
        ModelMapper m = new ModelMapper();
        MusicaMultimedia mm = m.map(dto, MusicaMultimedia.class);
        mmS.insert(mm);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Musica registrada correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        MusicaMultimedia musicaMultimedia = mmS.listId(id);
        if (musicaMultimedia == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe musica con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        MusicaMultimediaDTO dto = m.map(musicaMultimedia, MusicaMultimediaDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody MusicaMultimediaDTO dto) {
        ModelMapper m = new ModelMapper();
        MusicaMultimedia mm = m.map(dto, MusicaMultimedia.class);

        MusicaMultimedia existente = mmS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe musica con ID: " + dto.getId());
        }

        mmS.update(mm);
        return ResponseEntity.ok("Musica con ID " + dto.getId() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        MusicaMultimedia musicaMultimedia = mmS.listId(id);
        if (musicaMultimedia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una musica con el ID: " + id);
        }
        mmS.delete(id);
        return ResponseEntity.ok("Musica con ID " + id + " eliminada correctamente.");
    }
}
