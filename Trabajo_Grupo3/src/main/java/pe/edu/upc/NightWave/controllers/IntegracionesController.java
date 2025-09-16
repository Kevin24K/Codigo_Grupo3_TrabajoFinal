package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.IntegracionesDTO;
import pe.edu.upc.NightWave.entities.Integraciones;
import pe.edu.upc.NightWave.servicesinterfaces.IIntegracionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/integraciones")
public class IntegracionesController
{
    @Autowired
    private IIntegracionesService iS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<IntegracionesDTO> lista = iS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, IntegracionesDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen integraciones registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody IntegracionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Integraciones i = m.map(dto, Integraciones.class);
        iS.insert(i);
        return ResponseEntity.ok("Integracion registrada correctamente.");
    }
}
