package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.Objetivos_RecompensasDTO;
import pe.edu.upc.NightWave.entities.Objetivos;
import pe.edu.upc.NightWave.entities.Objetivos_Recompensas;
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
    public ResponseEntity<String> registrar(@RequestBody Objetivos_RecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        Objetivos_Recompensas or = m.map(dto, Objetivos_Recompensas.class);

        // Se debe buscar las entidades de Objetivos y Recompensas por sus IDs
        // Esto es una simplificación, en un caso real se necesitarían los servicios de Objetivos y Recompensas
        Objetivos o = new Objetivos();
        o.setId(dto.getIdObjetivo());
        Recompensas r = new Recompensas();
        r.setId(dto.getIdRecompensa());

        or.setObjetivo(o);
        or.setRecompensa(r);

        orS.insert(or);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Objetivos_RecompensasDTO> listar() {
        return orS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Objetivos_RecompensasDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        orS.delete(id);
    }

    @GetMapping("/{id}")
    public Objetivos_RecompensasDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(orS.listId(id), Objetivos_RecompensasDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody Objetivos_RecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        Objetivos_Recompensas or = m.map(dto, Objetivos_Recompensas.class);

        Objetivos o = new Objetivos();
        o.setId(dto.getIdObjetivo());
        Recompensas r = new Recompensas();
        r.setId(dto.getIdRecompensa());

        or.setObjetivo(o);
        or.setRecompensa(r);

        orS.update(or);
    }

    // Endpoint para la query personalizada
    @GetMapping("/por-objetivo/{idObjetivo}")
    public List<Objetivos_RecompensasDTO> findByObjetivoId(@PathVariable("idObjetivo") int objetivoId) {
        return orS.findByObjetivoId(objetivoId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Objetivos_RecompensasDTO.class);
        }).collect(Collectors.toList());
    }
}
