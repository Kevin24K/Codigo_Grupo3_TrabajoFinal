package pe.edu.upc.NightWave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.RolDTO;
import pe.edu.upc.NightWave.entities.Role;
import pe.edu.upc.NightWave.entities.Users;
import pe.edu.upc.NightWave.servicesinterfaces.IRoleService;
import pe.edu.upc.NightWave.servicesinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUsersService userService;

    //@PreAuthorize("hasAuthority('admin')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<RolDTO> lista = roleService.list().stream().map(role -> {
            RolDTO dto = new RolDTO();
            dto.setId(role.getId());
            dto.setRol(role.getRol());
            dto.setUser(role.getUser());
            return dto;
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen roles registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    //@PreAuthorize("hasAuthority('admin')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RolDTO dto) {
        if (dto.getRol() == null || dto.getRol().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del rol es obligatorio.");
        }

        if (dto.getUser() == null || dto.getUser().getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Debe especificarse el usuario asociado al rol.");
        }

        Users usuario = userService.listId(dto.getUser().getId());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El usuario con ID " + dto.getUser().getId() + " no existe.");
        }

        Role rol = new Role();
        rol.setRol(dto.getRol());
        rol.setUser(usuario);

        roleService.insert(rol);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Rol registrado correctamente.");
    }

    //@PreAuthorize("hasAuthority('admin')")
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable("id") Long id) {
        Role rol = roleService.listId(id.intValue());
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un rol con ID: " + id);
        }

        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setRol(rol.getRol());
        dto.setUser(rol.getUser());

        return ResponseEntity.ok(dto);
    }

    //@PreAuthorize("hasAuthority('admin')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
        if (dto.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Debe especificarse el ID del rol a modificar.");
        }

        Role existente = roleService.listId(dto.getId().intValue());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe rol con ID: " + dto.getId());
        }

        if (dto.getUser() == null || dto.getUser().getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Debe especificarse el usuario asociado al rol.");
        }

        Users usuario = userService.listId(dto.getUser().getId());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El usuario con ID " + dto.getUser().getId() + " no existe.");
        }

        existente.setRol(dto.getRol());
        existente.setUser(usuario);
        roleService.update(existente);

        return ResponseEntity.ok("Rol actualizado correctamente.");
    }

    //@PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Long id) {
        Role rol = roleService.listId(id.intValue());
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un rol con ID: " + id);
        }

        roleService.delete(id.intValue());
        return ResponseEntity.ok("Rol eliminado correctamente.");
    }
}
