package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.EntidadDTO;
import pe.edu.upc.catchthem.dtos.SospechosoDTO;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.serviceInterfaces.IEntidadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entidad")
public class EntidadController {
    @Autowired
    private IEntidadService iEntidadService;

    @PostMapping
    public void registrar(@RequestBody EntidadDTO entidadDTO){
        ModelMapper m= new ModelMapper();
        Entidad entidad = m.map(entidadDTO, Entidad.class);
        iEntidadService.insert(entidad);
    }

    @PutMapping
    public void modificar(@RequestBody EntidadDTO entidadDTO){
        ModelMapper m= new ModelMapper();
        Entidad entidad = m.map(entidadDTO, Entidad.class);
        iEntidadService.insert(entidad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        iEntidadService.delete(id);
    }

    @GetMapping
    public List<EntidadDTO> listar(){
        return iEntidadService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,EntidadDTO.class);
        }).collect(Collectors.toList());
    }
}
