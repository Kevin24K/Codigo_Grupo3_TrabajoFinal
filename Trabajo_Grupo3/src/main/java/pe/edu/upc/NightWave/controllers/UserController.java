package pe.edu.upc.NightWave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.entities.Users;
import pe.edu.upc.NightWave.servicesinterfaces.IUsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private IUsersService uS;

    // Listar todos los usuarios
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping
    public ResponseEntity<List<Users>> listarUsuarios() {
        return ResponseEntity.ok(uS.listarUsuarios());
    }

    // Buscar usuario por username
    @PreAuthorize("hasAnyAuthority('usuario','admin')")
    @GetMapping("/buscar/{username}")
    public ResponseEntity<Users> buscarPorUsername(@PathVariable String username) {
        Users user = uS.findByUsername(username);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Comprobar si existe username
    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/existe/{username}")
    public ResponseEntity<Boolean> existeUsername(@PathVariable String username) {
        boolean existe = uS.buscarUsername(username) > 0;
        return ResponseEntity.ok(existe);
    }

    // Insertar un rol para un usuario
    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/rol")
    public ResponseEntity<Void> insertarRol(@RequestParam String rol, @RequestParam Long userId) {
        uS.insertarRol(rol, userId);
        return ResponseEntity.ok().build();
    }
}
