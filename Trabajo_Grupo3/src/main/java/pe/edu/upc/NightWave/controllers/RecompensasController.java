package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.RecompensasDTO;
import pe.edu.upc.NightWave.entities.Recompensas;
import pe.edu.upc.NightWave.servicesinterfaces.IRecompensasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recompensas")
public class RecompensasController
{
    @Autowired
    private IRecompensasService rS;
    @GetMapping
    public ResponseEntity<?> listar() {
        List<RecompensasDTO> lista = rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecompensasDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen recompensas registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Recompensas recompensas = rS.listId(id);
        if (recompensas == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe Recompensa con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecompensasDTO dto = m.map(recompensas, RecompensasDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensas recompensas = m.map(dto, Recompensas.class);
        rS.insert(recompensas);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Recompensa registrada correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RecompensasDTO dto) {
        Recompensas existente = rS.listId(dto.getIdRecompensa());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe recompensa con ID: " + dto.getIdRecompensa());
        }
        ModelMapper m = new ModelMapper();
        Recompensas recompensas = m.map(dto, Recompensas.class);
        rS.update(recompensas);
        return ResponseEntity.ok("Recompensa con ID " + dto.getIdRecompensa() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recompensas existente = rS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe recompensa con ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Recompensa con ID " + id + " eliminada correctamente.");
    }
}
