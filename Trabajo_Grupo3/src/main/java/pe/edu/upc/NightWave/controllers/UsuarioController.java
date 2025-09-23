package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ListaUsuariosDTO;
import pe.edu.upc.NightWave.dtos.UsuarioDTO;
import pe.edu.upc.NightWave.entities.Usuario;
import pe.edu.upc.NightWave.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Usuario usuario = uS.listId(id);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe usuario con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ListaUsuariosDTO dto = m.map(usuario, ListaUsuariosDTO.class);
        dto.setRolId(usuario.getRol().getIdRol());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);
        usuario.getRol().setIdRol(dto.getRolId());
        uS.insert(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody UsuarioDTO dto) {
        Usuario existente = uS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe usuario con ID: " + dto.getId());
        }
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(dto, Usuario.class);
        usuario.getRol().setIdRol(dto.getRolId());
        uS.update(usuario);
        return ResponseEntity.ok("Usuario con ID " + dto.getId() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuario existente = uS.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe usuario con ID: " + id);
        }
        uS.delete(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/filtro/usuarios")
    public ResponseEntity<?> buscarUsuariosPorRol(@RequestParam(value = "rolId", required = false) Integer rolId) {
        if (rolId == null) {
            return ResponseEntity.ok("Debe proporcionar un rolId válido.");
        }

        List<Usuario> usuarios = uS.listarUsuariosPorRol(rolId);

        if (usuarios.isEmpty()) {
            return ResponseEntity.ok("No existen usuarios asociados al rol con ID " + rolId);
        }

        List<ListaUsuariosDTO> listaDTO = usuarios.stream().map(u -> {
            ModelMapper m = new ModelMapper();
            ListaUsuariosDTO dto = m.map(u, ListaUsuariosDTO.class);
            dto.setRolId(u.getRol().getIdRol());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}
