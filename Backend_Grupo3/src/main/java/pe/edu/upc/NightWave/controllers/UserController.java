package pe.edu.upc.NightWave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.UsuarioDTO;
import pe.edu.upc.NightWave.dtos.RegistroUsuarioDTO;
import pe.edu.upc.NightWave.entities.Users;
import pe.edu.upc.NightWave.servicesinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUsersService userService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        List<UsuarioDTO> lista = userService.list().stream().map(u -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setId(u.getId());
            dto.setUsername(u.getUsername());
            return dto;
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No hay usuarios registrados.");
        }

        return ResponseEntity.ok(lista);
    }

   @PreAuthorize("hasAnyAuthority('admin', 'usuario')")
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable("id") Long id) {
        Users user = userService.listId(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con ID: " + id);
        }

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEnabled(user.getEnabled());
        dto.setRoles(user.getRoles());
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RegistroUsuarioDTO dto) {
        if (dto.getUsername() == null || dto.getUsername().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre de usuario es obligatorio.");
        }

        if (dto.getPassword() == null || dto.getPassword().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La contraseña es obligatoria.");
        }

        if (userService.buscarUsername(dto.getUsername()) > 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El nombre de usuario ya está registrado.");
        }

        Users nuevo = new Users();
        nuevo.setUsername(dto.getUsername());
        nuevo.setPassword(dto.getPassword());
        nuevo.setEnabled(true);

        userService.insert(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario creado correctamente.");
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto) {
        if (dto.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Debe especificarse el ID del usuario a modificar.");
        }

        Users existente = userService.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con ID: " + dto.getId());
        }

        existente.setUsername(dto.getUsername() != null ? dto.getUsername() : existente.getUsername());
        existente.setPassword(dto.getPassword() != null ? dto.getPassword() : existente.getPassword());
        existente.setEnabled(dto.getEnabled() != null ? dto.getEnabled() : existente.getEnabled());
        existente.setRoles(dto.getRoles() != null ? dto.getRoles() : existente.getRoles());

        userService.update(existente);
        return ResponseEntity.ok("Usuario actualizado correctamente.");
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Long id) {
        Users existente = userService.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con ID: " + id);
        }

        userService.delete(id);
        return ResponseEntity.ok("Usuario eliminado correctamente.");
    }

    @PreAuthorize("hasAnyAuthority('usuario','admin')")
    @GetMapping("/buscar/{username}")
    public ResponseEntity<?> buscarPorUsername(@PathVariable String username) {
        Users user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con username: " + username);
        }

        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEnabled(user.getEnabled());
        dto.setRoles(user.getRoles());
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/existe/{username}")
    public ResponseEntity<Boolean> existeUsername(@PathVariable String username) {
        boolean existe = userService.buscarUsername(username) > 0;
        return ResponseEntity.ok(existe);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/rol")
    public ResponseEntity<String> insertarRol(@RequestParam String rol, @RequestParam Long userId) {
        Users user = userService.listId(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con ID: " + userId);
        }

        userService.insertarRol(rol, userId);
        return ResponseEntity.ok("Rol '" + rol + "' asignado al usuario con ID " + userId);
    }
}
