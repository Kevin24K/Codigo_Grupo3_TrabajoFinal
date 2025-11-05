package pe.edu.upc.NightWave.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.NightWave.servicesinterfaces.IRoleService;

@RestController
@RequestMapping("/roles")
public class RolController
{
    @Autowired
    private IRoleService rS;

}
