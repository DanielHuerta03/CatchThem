package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.EntidadDTO;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.serviceInterfaces.IEntidadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entidades")
public class EntidadController {

    @Autowired
    //eS <-> entidadService
    private IEntidadService eS;

    @PostMapping
    public void registrar(@RequestBody EntidadDTO entidadDTO){
        ModelMapper m= new ModelMapper();
        Entidad entidad = m.map(entidadDTO,Entidad.class);
        eS.insertar(entidad);
    }
    @GetMapping
    public List<EntidadDTO> listar(){
        return eS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,EntidadDTO.class);
        }).collect(Collectors.toList());

    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        eS.eliminar(id);
    }

}
