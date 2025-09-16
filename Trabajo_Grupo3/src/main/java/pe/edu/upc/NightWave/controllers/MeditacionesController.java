package pe.edu.upc.NightWave.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.NightWave.dtos.MeditacionesDTO;
import pe.edu.upc.NightWave.entities.Meditaciones;
import pe.edu.upc.NightWave.servicesinterfaces.IMeditacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meditaciones")
public class MeditacionesController
{
    @Autowired
    private IMeditacionService mS;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<MeditacionesDTO> lista = mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MeditacionesDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No existen meditaciones registradas.");
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<String> registrar(@RequestBody MeditacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Meditaciones me = m.map(dto, Meditaciones.class);
        mS.insert(me);
        return ResponseEntity.ok("Meditación registrada correctamente.");
    }
}
