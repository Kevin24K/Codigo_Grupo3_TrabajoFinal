package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.PromedioHorasSuenoDTO;
import pe.edu.upc.NightWave.dtos.RelacionEstresCalidadDTO;
import pe.edu.upc.NightWave.dtos.SuenoDTO;
import pe.edu.upc.NightWave.entities.Sueno;
import pe.edu.upc.NightWave.servicesinterfaces.ISuenoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/suenos")
public class SuenoController {
    @Autowired
    private ISuenoService sS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<SuenoDTO> lista = sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, SuenoDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen sueños registrados.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody SuenoDTO dto) {
        ModelMapper m = new ModelMapper();
        Sueno s = m.map(dto, Sueno.class);
        sS.insert(s);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Sueño registrado correctamente.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable("id") Integer id) {
        Sueno sueno = sS.listId(id);
        if (sueno == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe sueños con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        SuenoDTO dto = m.map(sueno, SuenoDTO.class);
        return ResponseEntity.ok(dto);
    }


    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody SuenoDTO dto) {
        ModelMapper m = new ModelMapper();
        Sueno su = m.map(dto, Sueno.class);

        Sueno existente = sS.listId(dto.getId());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe sueños con ID: " + dto.getId());
        }

        sS.update(su);
        return ResponseEntity.ok("Sueño con ID " + dto.getId() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Sueno suenio = sS.listId(id);
        if (suenio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un sueño con el ID: " + id);
        }
        sS.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }


    @GetMapping("/buscar-por-calidad-de-sueno")
    public ResponseEntity<?> buscarPorCalidadDeSueno(@RequestParam(value = "calidad", required = false) Integer calidad) {
        if (calidad == null) {
            return ResponseEntity.ok("Debe proporcionar un valor de calidad de sueño válido.");
        }

        List<Sueno> lista = sS.BuscarPorCalidadDeSueno(calidad);

        if (lista.isEmpty()) {
            return ResponseEntity.ok("No hay registros con esa calidad de sueño.");
        }

        List<SuenoDTO> listaDTO = lista.stream().map(s -> {
            ModelMapper m = new ModelMapper();
            return m.map(s, SuenoDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/promedio/{usuarioId}")
    public ResponseEntity<?> promedioHorasUsuario(@PathVariable int usuarioId) {
        Double promedio = sS.promedioHorasDormidasPorUsuario(usuarioId);

        if (promedio == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no tiene registros de sueño.");
        }

        PromedioHorasSuenoDTO dto = new PromedioHorasSuenoDTO();
        dto.setUsuarioId(usuarioId);
        dto.setPromedioHorasDormidas(promedio);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/promedio/todos")
    public ResponseEntity<?> promedioHorasTodosUsuarios() {
        List<Object[]> resultados = sS.promedioHorasDormidasTodosUsuarios();

        if (resultados.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron registros de sueño para ningún usuario.");
        }

        List<PromedioHorasSuenoDTO> listaDTO = new ArrayList<>();
        for (Object[] fila : resultados) {
            PromedioHorasSuenoDTO dto = new PromedioHorasSuenoDTO();
            dto.setUsuarioId((Integer) fila[0]);
            dto.setPromedioHorasDormidas((Double) fila[1]);
            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/relacion/estres-calidad/{usuarioId}")
    public ResponseEntity<?> relacionEstresCalidadPorUsuario(@PathVariable int usuarioId) {
        Object[] resultado = sS.relacionEstresCalidadPorUsuario(usuarioId);

        if (resultado == null || resultado[0] == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario no tiene registros de sueño.");
        }

        RelacionEstresCalidadDTO dto = new RelacionEstresCalidadDTO();
        dto.setUsuarioId((Integer) resultado[0]);
        dto.setPromedioEstres((Double) resultado[1]);
        dto.setPromedioCalidadSueno((Double) resultado[2]);
        dto.setCorrelacionEstresCalidad((Double) resultado[3]);

        return ResponseEntity.ok(dto);
    }

}