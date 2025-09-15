package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.SonidoDTO;
import pe.edu.upc.NightWave.entities.Sonido;
import pe.edu.upc.NightWave.servicesinterfaces.ISonidoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sonidos")
public class SonidoController {
    @Autowired
    private ISonidoService sS;

    @GetMapping
    public List<SonidoDTO> listar(){
        return sS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SonidoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody SonidoDTO dto){
        ModelMapper m = new ModelMapper();
        Sonido a = m.map(dto, Sonido.class);
        sS.insert(a);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Sonido area = sS.listId(id);
        if (area == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        sS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody SonidoDTO dto) {
        ModelMapper m = new ModelMapper();
        Sonido sr = m.map(dto, Sonido.class);

        Sonido existente = sS.listId(sr.getIdSonido());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + sr.getIdSonido());
        }
        sS.update(sr);
        return ResponseEntity.ok("Registro con ID " + sr.getIdSonido() + " modificado correctamente.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Sonido sonido = sS.listId(id);
        if (sonido == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        SonidoDTO dto = m.map(sonido, SonidoDTO.class);
        return ResponseEntity.ok(dto);
    }
}