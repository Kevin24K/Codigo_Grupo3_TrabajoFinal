package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.NotificacionDTO;
import pe.edu.upc.NightWave.dtos.ObjetivosRecompensasDTO;
import pe.edu.upc.NightWave.entities.Notificacion;
import pe.edu.upc.NightWave.entities.Objetivos;
import pe.edu.upc.NightWave.entities.ObjetivosRecompensas;
import pe.edu.upc.NightWave.entities.Recompensas;
import pe.edu.upc.NightWave.servicesinterfaces.IObjetivosRecompensasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivosrecompensas")
public class ObjetivosRecompensasController {
    @Autowired
    private IObjetivosRecompensasService orS;

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ObjetivosRecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        ObjetivosRecompensas o = m.map(dto, ObjetivosRecompensas.class);
        orS.insert(o);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("ObjetivoRecompensa registrado correctamente.");
    }


    @GetMapping
    public List<ObjetivosRecompensasDTO> listar() {
        return orS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObjetivosRecompensasDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        orS.delete(id);
    }

    @GetMapping("/{id}")
    public ObjetivosRecompensasDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(orS.listId(id), ObjetivosRecompensasDTO.class);
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ObjetivosRecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        ObjetivosRecompensas or = m.map(dto, ObjetivosRecompensas.class);

        ObjetivosRecompensas existente = orS.listId(dto.getIdObjetivosRecompensas());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe Objetivo Recompensa con ID: " + dto.getIdObjetivosRecompensas());
        }

        orS.update(or);
        return ResponseEntity.ok("Objetivo Recompensa con ID " + dto.getIdObjetivosRecompensas() + " modificado correctamente.");
    }


}
