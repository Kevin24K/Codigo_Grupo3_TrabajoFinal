package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyAuthority('coach','admin','analista')")
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

    @PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RecompensasDTO dto) {
        ModelMapper m = new ModelMapper();
        Recompensas r = m.map(dto, Recompensas.class);
        rS.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Recompensa registrado correctamente.");
    }

    @PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Recompensas recompensas = rS.listId(id);
        if (recompensas == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe recompensa con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecompensasDTO dto = m.map(recompensas, RecompensasDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyAuthority('coach','admin')")
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
        return ResponseEntity.ok("Recompensa con ID " + dto.getIdRecompensa() + " modificado correctamente.");
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recompensas recompensas = rS.listId(id);
        if (recompensas == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una recompensa con el ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PreAuthorize("hasAnyAuthority('analista','admin')")
    @GetMapping("/buscarportiporecompensa")
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
