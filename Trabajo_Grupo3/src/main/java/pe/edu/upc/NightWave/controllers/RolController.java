package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.RolDTO;
import pe.edu.upc.NightWave.entities.Rol;
import pe.edu.upc.NightWave.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private IRolService rS;

    // Listar todos los roles
    @GetMapping
    public ResponseEntity<?> listar() {
        List<RolDTO> lista = rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
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
        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del rol es obligatorio.");
        }

        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
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
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(rol, RolDTO.class);
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
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rS.update(rol);
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
