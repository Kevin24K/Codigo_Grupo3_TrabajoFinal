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
public class RecompensaController
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
                    .body("No existen notificaciones registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensas r = m.map(dto, Recompensas.class);
        rS.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Estres registrado correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Recompensas recompensas = rS.listId(id);
        if (recompensas == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe estres con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecompensasDTO dto = m.map(recompensas, RecompensasDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensas r = m.map(dto, Recompensas.class);

        Recompensas existente = rS.listId(dto.getIdRecompensa());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe notificaicones con ID: " + dto.getIdRecompensa());
        }

        rS.update(r);
        return ResponseEntity.ok("Control parental con ID " + dto.getIdRecompensa() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recompensas recompensas = rS.listId(id);
        if (recompensas == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una notificacion con el ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/buscar-por-tipo-recompensa")
    public ResponseEntity<?> buscarRecompensasPorTipo(@RequestParam(value = "tipo", required = false) String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            return ResponseEntity.ok("Debe proporcionar un tipo de recompensa válido.");
        }

        List<Recompensas> lista = rS.listarPorTipoRecompensa(tipo);

        if (lista.isEmpty()) {
            return ResponseEntity.ok("No se encontraron recompensas del tipo: " + tipo);
        }

        List<RecompensasDTO> listaDTO = lista.stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, RecompensasDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

}
