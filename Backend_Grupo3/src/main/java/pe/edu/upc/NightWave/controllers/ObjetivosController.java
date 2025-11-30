package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.AlarmaDTO;
import pe.edu.upc.NightWave.dtos.ObjetivosAlcanzadosDTO;
import pe.edu.upc.NightWave.dtos.ObjetivosDTO;
import pe.edu.upc.NightWave.dtos.PromedioProgresoDTO;
import pe.edu.upc.NightWave.entities.Alarma;
import pe.edu.upc.NightWave.entities.Objetivos;
import pe.edu.upc.NightWave.servicesinterfaces.IAlarmaService;
import pe.edu.upc.NightWave.servicesinterfaces.IObjetivosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivos")
public class ObjetivosController {
    @Autowired
    private IObjetivosService oS;

    //@PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping
    public ResponseEntity<?> listar() {
        List<ObjetivosDTO> lista = oS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ObjetivosDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen objetivos registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    //@PreAuthorize("hasAnyAuthority('coach','usuario','analista','admin')")
    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody ObjetivosDTO dto) {
        ModelMapper m = new ModelMapper();
        Objetivos o = m.map(dto, Objetivos.class);
        oS.insert(o);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Objetivo registrada correctamente.");
    }

    @PreAuthorize("hasAnyAuthority('coach','admin','analista')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Objetivos objetivos = oS.listId(id);
        if (objetivos == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe objetivo con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        ObjetivosDTO dto = m.map(objetivos, ObjetivosDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyAuthority('coach','admin')")
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ObjetivosDTO dto) {
        ModelMapper m = new ModelMapper();
        Objetivos ob = m.map(dto, Objetivos.class);

        Objetivos existente = oS.listId(dto.getIdObjetivos());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe objetivo con ID: " + dto.getIdObjetivos());
        }

        oS.update(ob);
        return ResponseEntity.ok("Objetivo con ID " + dto.getIdObjetivos() + " modificado correctamente.");
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Objetivos objetivos = oS.listId(id);
        if (objetivos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un objetivo con el ID: " + id);
        }
        oS.delete(id);
        return ResponseEntity.ok("Objetivo con ID " + id + " eliminado correctamente.");
    }


    @PreAuthorize("hasAnyAuthority('analista','admin')")
    @GetMapping("/promedioProgreso")
    public ResponseEntity<?> obtenerPromedioProgreso() {
        List<PromedioProgresoDTO> listaDto = new ArrayList<>();
        List<String[]> filas = oS.obtenerPromedioProgresoPorUsuario();

        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros de progreso de objetivos");
        }

        for (String[] x : filas) {
            PromedioProgresoDTO dto = new PromedioProgresoDTO();
            dto.setNombreUsuario(x[0]);
            dto.setPromedioProgreso(Double.parseDouble(x[1]));
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }


    @PreAuthorize("hasAnyAuthority('coach','admin')")
    @GetMapping("/objetivos-alcanzados-x-usuario")
    public ResponseEntity<?> contarObjetivosPorUsuario() {
        List<ObjetivosAlcanzadosDTO> listaDto = new ArrayList<>();
        List<String[]> filas = oS.objetivosAlcanzadosPorUsuario();

        if (filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros");
        }

        for (String[] x : filas) {
            ObjetivosAlcanzadosDTO dto = new ObjetivosAlcanzadosDTO();
            dto.setNombreUsuario(x[0]);
            dto.setObjetivosAlcanzados(Integer.parseInt(x[1]));
            dto.setObjetivosNoAlcanzados(Integer.parseInt(x[2]));
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }


}
