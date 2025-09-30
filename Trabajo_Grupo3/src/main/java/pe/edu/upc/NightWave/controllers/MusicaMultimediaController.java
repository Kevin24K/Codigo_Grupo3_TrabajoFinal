package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.HabitosDTO;
import pe.edu.upc.NightWave.dtos.MusicaMultimediaDTO;
import pe.edu.upc.NightWave.entities.Habitos;
import pe.edu.upc.NightWave.entities.MusicaMultimedia;
import pe.edu.upc.NightWave.servicesinterfaces.IHabitosService;
import pe.edu.upc.NightWave.servicesinterfaces.IMusicaMultimediaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/musicasMultimedia")
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
                .body("Musica Multimedia registrada correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        MusicaMultimedia musicaMultimedia = mmS.listId(id);
        if (musicaMultimedia == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe musica multimedia con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        MusicaMultimediaDTO dto = m.map(musicaMultimedia, MusicaMultimediaDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody MusicaMultimediaDTO dto) {
        ModelMapper m = new ModelMapper();
        MusicaMultimedia mm = m.map(dto, MusicaMultimedia.class);

        MusicaMultimedia existente = mmS.listId(dto.getIdMusicaMultimedia());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe musica multimedia con ID: " + dto.getIdMusicaMultimedia());
        }

        mmS.update(mm);
        return ResponseEntity.ok("Musica Multimedia con ID " + dto.getIdMusicaMultimedia() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        MusicaMultimedia musicaMultimedia = mmS.listId(id);
        if (musicaMultimedia == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una musica multimedia con el ID: " + id);
        }
        mmS.delete(id);
        return ResponseEntity.ok("Musica Multimedia con ID " + id + " eliminado correctamente.");
    }
}
