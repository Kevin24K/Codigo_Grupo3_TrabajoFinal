package pe.edu.upc.NigthWave.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NigthWave.dtos.ListaUsuariosDTO;
import pe.edu.upc.NigthWave.dtos.UsuarioDTO;
import pe.edu.upc.NigthWave.entities.Rol;
import pe.edu.upc.NigthWave.entities.Usuario;
import pe.edu.upc.NigthWave.repositories.IRolRepository;
import pe.edu.upc.NigthWave.servicesinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @Autowired
    private IRolRepository rR;

    // LISTAR TODOS
    @GetMapping

    public ResponseEntity<?> listar() {
        List<UsuarioDTO> lista = uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen usuarios registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    // LISTAR POR ID
    @GetMapping("/{id}")

    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Usuario usuario = uS.listId(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe usuario con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ListaUsuariosDTO dto = m.map(usuario, ListaUsuariosDTO.class);

        if (!usuario.getRoles().isEmpty()) {
            dto.setRolId(usuario.getRoles().get(0).getIdRol()); // Tomamos el primer rol
        }

        return ResponseEntity.ok(dto);
    }

    // REGISTRAR
    @PostMapping

    public ResponseEntity<String> registrar(@RequestBody UsuarioDTO dto) {
        if (dto.getRolId() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Debe proporcionar un rolId válido para registrar el usuario.");
        }

        boolean rolExiste = rR.existsById(dto.getRolId());
        if (!rolExiste) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El rol con ID " + dto.getRolId() + " no existe en el sistema.");
        }

        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);

        // Asignamos el rol como lista con un único elemento
        Rol rol = rR.findById(dto.getRolId()).orElse(null);
        List<Rol> roles = new ArrayList<>();
        roles.add(rol);
        usuario.setRoles(roles);

        uS.insert(usuario);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario registrado correctamente.");
    }

    // MODIFICAR
    @PutMapping

    public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto) {
        Usuario existente = uS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe usuario con ID: " + dto.getId());
        }

        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);

        Rol rol = rR.findById(dto.getRolId()).orElse(null);
        List<Rol> roles = new ArrayList<>();
        roles.add(rol);
        usuario.setRoles(roles);

        uS.update(usuario);
        return ResponseEntity.ok("Usuario con ID " + dto.getId() + " modificado correctamente.");
    }

    // ELIMINAR
    @DeleteMapping("/{id}")

    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario existente = uS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe usuario con ID: " + id);
        }
        uS.delete(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }
}
