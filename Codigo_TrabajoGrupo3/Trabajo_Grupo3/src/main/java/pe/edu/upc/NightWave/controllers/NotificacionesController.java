package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.NotificacionesDTO;
import pe.edu.upc.NightWave.entities.Notificaciones;
import pe.edu.upc.NightWave.entities.Usuario;
import pe.edu.upc.NightWave.servicesinterfaces.INotificacionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {
    @Autowired
    private INotificacionesService nS;

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones notificacion = m.map(dto, Notificaciones.class);

        // Se debe buscar la entidad Usuario por su ID
        // Esto es una simplificación, en un caso real se necesitaría el servicio de Usuario
        Usuario usuario = new Usuario();
        usuario.setId(dto.getUsuarioId());
        notificacion.setUsuario(usuario);

        nS.insert(notificacion);
        return new ResponseEntity<>("Registro exitoso", HttpStatus.CREATED);
    }

    @GetMapping
    public List<NotificacionesDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        nS.delete(id);
    }

    @GetMapping("/{id}")
    public NotificacionesDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        return m.map(nS.listId(id), NotificacionesDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones notificacion = m.map(dto, Notificaciones.class);

        // Asignar el usuario
        Usuario usuario = new Usuario();
        usuario.setId(dto.getUsuarioId());
        notificacion.setUsuario(usuario);

        nS.update(notificacion);
    }

    // Endpoint para la query personalizada: Notificaciones de un usuario
    @GetMapping("/por-usuario/{usuarioId}")
    public List<NotificacionesDTO> findByUsuarioId(@PathVariable("usuarioId") int usuarioId) {
        return nS.findByUsuarioId(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }

    // Endpoint para la query personalizada: Notificaciones no leídas de un usuario
    @GetMapping("/por-usuario/no-leidas/{usuarioId}")
    public List<NotificacionesDTO> findByUsuarioIdAndLeidaFalse(@PathVariable("usuarioId") int usuarioId) {
        return nS.findByUsuarioIdAndLeidaFalse(usuarioId).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }
}
