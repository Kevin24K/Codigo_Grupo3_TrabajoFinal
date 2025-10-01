package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.RolDTO;
import pe.edu.upc.NigthWave.entities.Rol;
import pe.edu.upc.NigthWave.entities.Usuario;
import pe.edu.upc.NigthWave.servicesinterfaces.IRolService;
import pe.edu.upc.NigthWave.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;

    @Autowired
    private IUsuarioService uS;

    // Listar todos los roles
    @GetMapping
    public ResponseEntity<?> listar() {
        List<RolDTO> lista = rS.list().stream().map(x -> {
            RolDTO dto = new RolDTO();
            dto.setIdRol(x.getIdRol());
            dto.setNombre(x.getNombre());
            dto.setUserId(x.getUser().getId()); // aquí tomamos el id del usuario relacionado
            return dto;
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen roles registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    // Registrar rol
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RolDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del rol es obligatorio.");
        }

        Usuario usuario = uS.listId(dto.getUserId());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El userId " + dto.getUserId() + " no existe.");
        }

        Rol rol = new Rol();
        rol.setNombre(dto.getNombre());
        rol.setUser(usuario);

        rS.insert(rol);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Rol registrado correctamente.");
    }

    // Listar rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Rol rol = rS.listId(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un rol con ID: " + id);
        }

        RolDTO dto = new RolDTO();
        dto.setIdRol(rol.getIdRol());
        dto.setNombre(rol.getNombre());
        dto.setUserId(rol.getUser().getId());

        return ResponseEntity.ok(dto);
    }

    // Modificar rol
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
        Rol existente = rS.listId(dto.getIdRol());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe rol con ID: " + dto.getIdRol());
        }

        Usuario usuario = uS.listId(dto.getUserId());
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El userId " + dto.getUserId() + " no existe.");
        }

        existente.setNombre(dto.getNombre());
        existente.setUser(usuario);

        rS.update(existente);
        return ResponseEntity.ok("Rol con ID " + dto.getIdRol() + " modificado correctamente.");
    }

    // Eliminar rol
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Rol rol = rS.listId(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un rol con ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Rol con ID " + id + " eliminado correctamente.");
    }
}
