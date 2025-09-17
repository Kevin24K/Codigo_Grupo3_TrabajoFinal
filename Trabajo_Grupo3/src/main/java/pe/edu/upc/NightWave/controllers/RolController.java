package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.RolDTO;
import pe.edu.upc.NightWave.dtos.UsuarioDTO;
import pe.edu.upc.NightWave.entities.Rol;
import pe.edu.upc.NightWave.entities.Usuario;
import pe.edu.upc.NightWave.servicesinterfaces.IRolService;
import pe.edu.upc.NightWave.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;

    @Autowired
    private IUsuarioService uS;

    // 📌 Listar todos los roles
    @GetMapping
    public ResponseEntity<?> listar() {
        List<RolDTO> lista = rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("No existen roles registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Rol rol = rS.listId(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un rol con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rol, RolDTO.class);
        return ResponseEntity.ok(dto);
    }

    // 📌 Registrar rol
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rS.insert(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rol registrado correctamente.");
    }

    // 📌 Modificar rol
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
        Rol existente = rS.listId(dto.getIdRol());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe rol con ID: " + dto.getIdRol());
        }
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rS.update(rol);
        return ResponseEntity.ok("Rol con ID " + dto.getIdRol() + " modificado correctamente.");
    }

    // 📌 Eliminar rol
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Rol rol = rS.listId(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un rol con ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Rol con ID " + id + " eliminado correctamente.");
    }

    // 📌 Listar usuarios por nombre de rol
    @GetMapping("/{nombreRol}/usuarios")
    public ResponseEntity<?> listarUsuariosPorRol(@PathVariable("nombreRol") String nombreRol) {
        List<UsuarioDTO> lista = uS.listByRolNombre(nombreRol).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            UsuarioDTO dto = m.map(x, UsuarioDTO.class);
            dto.setRolId(x.getRol().getIdRol()); // Asigna el ID del rol al DTO
            return dto;
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen usuarios con el rol: " + nombreRol);
        }
        return ResponseEntity.ok(lista);
    }
}
