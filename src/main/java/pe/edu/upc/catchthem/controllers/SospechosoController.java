package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.catchthem.dtos.SospechosoDTO;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.serviceinterfaces.ISospechosoService;

@RestController
@RequestMapping("/sospechoso")
public class SospechosoController {

    @Autowired
    private ISospechosoService iSospechosoService;

    @PostMapping
    public void registrar(@RequestBody SospechosoDTO sospechosoDTO){
        ModelMapper m= new ModelMapper();
        Sospechoso ap = m.map(sospechosoDTO, Sospechoso.class);
        iSospechosoService.insert(ap);
    }

    //falta otros metodos para el HU
}
