package pe.edu.upc.NigthWave.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.NotificacionDTO;
import pe.edu.upc.NigthWave.entities.Notificacion;
import pe.edu.upc.NigthWave.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private INotificacionService nS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<NotificacionDTO> lista = nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen notificaciones registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        nS.insert(n);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Notificacion registrada correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Notificacion notificacion = nS.listId(id);
        if (notificacion == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe notificacion con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        NotificacionDTO dto = m.map(notificacion, NotificacionDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion no = m.map(dto, Notificacion.class);

        Notificacion existente = nS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe notificaciones con ID: " + dto.getId());
        }

        nS.update(no);
        return ResponseEntity.ok("Notificacion con ID " + dto.getId() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Notificacion notificacion = nS.listId(id);
        if (notificacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una notificacion con el ID: " + id);
        }
        nS.delete(id);
        return ResponseEntity.ok("Notificacion con ID " + id + " eliminado correctamente.");
    }
    // Endpoint para la query personalizada: Notificaciones de un usuario
    @GetMapping("/por-usuario/{usuarioId}")
    public List<NotificacionDTO> findByUsuarioId(@PathVariable("usuarioId") int usuarioId) {
        return nS.findByUsuarioId(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    // Endpoint para la query personalizada: Notificaciones no leídas de un usuario
    @GetMapping("/por-usuario/no-leidas/{usuarioId}")
    public List<NotificacionDTO> findByUsuarioIdAndLeidaFalse(@PathVariable("usuarioId") int usuarioId) {
        return nS.findByUsuarioIdAndLeidaFalse(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }
}