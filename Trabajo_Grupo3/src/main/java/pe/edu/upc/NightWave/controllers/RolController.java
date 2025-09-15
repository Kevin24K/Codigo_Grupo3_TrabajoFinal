package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.RolDTO;
import pe.edu.upc.NightWave.dtos.UsuarioDTO;
import pe.edu.upc.NightWave.entities.Rol;
import pe.edu.upc.NightWave.servicesinterfaces.IRolService;
import pe.edu.upc.NightWave.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rol")
public class RolController 
{
    @Autowired
    private IRolService rS;

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
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);

        rS.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Rol registrado correctamente.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Rol rol = rS.listId(id);
        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        rS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);

        Rol existente = rS.listId(r.getIdRol());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + r.getIdRol());
        }
        rS.update(r);
        return ResponseEntity.ok("Registro con ID " + r.getIdRol() + " modificado correctamente.");
    }

    @Autowired
    private IUsuarioService uS;

    @GetMapping("/{nombreRol}/usuarios")

    public ResponseEntity<?> listarUsuariosPorRol(@PathVariable("nombreRol") String nombreRol) {
        List<UsuarioDTO> lista = uS.listByRolNombre(nombreRol).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen usuarios con el rol: " + nombreRol);
        }
        return ResponseEntity.ok(lista);
    }
}
