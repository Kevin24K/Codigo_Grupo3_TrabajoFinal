package pe.edu.upc.NightWave.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.NotificacionDTO;
import pe.edu.upc.NightWave.entities.Notificacion;
import pe.edu.upc.NightWave.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {
    @Autowired
    private INotificacionService nS;

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
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

    //@PreAuthorize("hasAnyAuthority('coach','usuario','analista','admin')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion n = m.map(dto, Notificacion.class);
        nS.insert(n);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Notificacion registrada correctamente.");
    }

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
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

    //@PreAuthorize("hasAnyAuthority('coach','admin')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificacion no = m.map(dto, Notificacion.class);

        Notificacion existente = nS.listId(dto.getIdNotificacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe notificaciones con ID: " + dto.getIdNotificacion());
        }

        nS.update(no);
        return ResponseEntity.ok("Control parental con ID " + dto.getIdNotificacion() + " modificado correctamente.");
    }

    //@PreAuthorize("hasAuthority('admin')")
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


    //@PreAuthorize("hasAnyAuthority('usuario','admin')")
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<?> listarPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        List<NotificacionDTO> lista = nS.listarPorUsuario(idUsuario).stream()
                .map(x -> new ModelMapper().map(x, NotificacionDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No hay notificaciones para el usuario con ID: " + idUsuario);
        }
        return ResponseEntity.ok(lista);
    }

    //@PreAuthorize("hasAnyAuthority('usuario','admin')")
    @GetMapping("/usuario/{idUsuario}/no-leidas")
    public ResponseEntity<?> listarNoLeidas(@PathVariable("idUsuario") Long idUsuario) {
        List<NotificacionDTO> lista = nS.listarNoLeidasPorUsuario(idUsuario).stream()
                .map(x -> new ModelMapper().map(x, NotificacionDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No hay notificaciones no leídas para el usuario con ID: " + idUsuario);
        }
        return ResponseEntity.ok(lista);
    }

}