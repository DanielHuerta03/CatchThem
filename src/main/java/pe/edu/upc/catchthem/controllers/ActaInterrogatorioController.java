package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.ActaInterrogatorioDTO;
import pe.edu.upc.catchthem.entities.ActasInterrogatorio;
import pe.edu.upc.catchthem.serviceInterfaces.IActaInterrogatorioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actas")
public class ActaInterrogatorioController {

    @Autowired
    //aS <->actaInterrogatorioService
    private IActaInterrogatorioService aS;

    @PostMapping
    @PreAuthorize("hasAuthority('POLICIA')")
    public void ingresar(@RequestBody ActaInterrogatorioDTO actaInterrogatorioDTO){
        ModelMapper m = new ModelMapper();
        ActasInterrogatorio actasInterrogatorio=m.map(actaInterrogatorioDTO, ActasInterrogatorio.class);
        aS.insertar(actasInterrogatorio);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('POLICIA') or hasAuthority('AGENTE')")
    public List<ActaInterrogatorioDTO> listar(){
        return aS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,ActaInterrogatorioDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        aS.eliminar(id);
    }
}