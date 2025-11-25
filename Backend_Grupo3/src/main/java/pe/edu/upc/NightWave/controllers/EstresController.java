package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.ConteoEstresXMesDTO;
import pe.edu.upc.NightWave.dtos.EstresDTO;
import pe.edu.upc.NightWave.dtos.PromedioEstresDTO;
import pe.edu.upc.NightWave.entities.Estres;
import pe.edu.upc.NightWave.servicesinterfaces.IEstresService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estres")
public class EstresController {
    @Autowired
    private IEstresService eS;

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<EstresDTO> lista = eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EstresDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen estres registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    //@PreAuthorize("hasAnyAuthority('coach','usuario','analista','admin')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody EstresDTO dto) {
        ModelMapper m = new ModelMapper();
        Estres e = m.map(dto, Estres.class);
        eS.insert(e);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Estres registrado correctamente.");
    }

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Estres estres = eS.listId(id);
        if (estres == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe estres con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        EstresDTO dto = m.map(estres, EstresDTO.class);
        return ResponseEntity.ok(dto);
    }

    //@PreAuthorize("hasAnyAuthority('coach','admin')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody EstresDTO dto) {
        ModelMapper m = new ModelMapper();
        Estres es = m.map(dto, Estres.class);

        Estres existente = eS.listId(dto.getIdEstres());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe estres con ID: " + dto.getIdEstres());
        }

        eS.update(es);
        return ResponseEntity.ok("Estres con ID " + dto.getIdEstres() + " modificado correctamente.");
    }

    //@PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Estres estres = eS.listId(id);
        if (estres == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un estres con el ID: " + id);
        }
        eS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    //Query
    //@PreAuthorize("hasAnyAuthority('coach','admin')")
    @GetMapping("/promedio")
    public ResponseEntity<?> obtenerPromedioEstresAnsiedad() {
        List<String[]> filas = eS.promedioEstresYAnsiedadPorUsuario();
        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        List<PromedioEstresDTO> listaDto = new ArrayList<>();
        for (String[] x : filas) {
            PromedioEstresDTO dto = new PromedioEstresDTO();
            dto.setNombreUsuario(x[0]);
            dto.setPromedioEstres(Double.parseDouble(x[1]));
            dto.setPromedioAnsiedad(Double.parseDouble(x[2]));
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }

    //Query
    //@PreAuthorize("hasAuthority('admin')")
    @GetMapping("/conteo-mensual")
    public ResponseEntity<?> obtenerConteoEstresPorMes() {
        List<String[]> filas = eS.conteoEstresPorMes();
        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        List<ConteoEstresXMesDTO> listaDto = new ArrayList<>();
        for (String[] x : filas) {
            ConteoEstresXMesDTO dto = new ConteoEstresXMesDTO();
            dto.setMes(x[0]);
            dto.setCantidadRegistros(Integer.parseInt(x[1]));
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }

}