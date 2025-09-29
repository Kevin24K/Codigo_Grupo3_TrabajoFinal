package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ObjetivosRecompensasDTO;
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
        ObjetivosRecompensas or = m.map(dto, ObjetivosRecompensas.class);

        Objetivos o = new Objetivos();
        o.setId(dto.getId());
        Recompensas r = new Recompensas();
        r.setIdRecompensa(dto.getId());

        or.setObjetivo(o);
        or.setRecompensa(r);

        orS.insert(or);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.CREATED);
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
    public void modificar(@RequestBody ObjetivosRecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        ObjetivosRecompensas or = m.map(dto, ObjetivosRecompensas.class);

        Objetivos o = new Objetivos();
        o.setId(dto.getId());
        Recompensas r = new Recompensas();
        r.setIdRecompensa(dto.getId());

        or.setObjetivo(o);
        or.setRecompensa(r);

        orS.update(or);
    }

    @GetMapping("/por-objetivo/{idObjetivo}")
    public List<ObjetivosRecompensasDTO> findByObjetivoId(@PathVariable("idObjetivo") int objetivoId) {
        return orS.findByObjetivoId(objetivoId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObjetivosRecompensasDTO.class);
        }).collect(Collectors.toList());
    }
}
