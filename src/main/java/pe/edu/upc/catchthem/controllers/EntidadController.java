package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.EntidadDTO;
import pe.edu.upc.catchthem.dtos.SospechosoDTO;
import pe.edu.upc.catchthem.dtos.SospechosoEntidadDTO;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.serviceInterfaces.IEntidadService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entidad")
public class EntidadController {
    @Autowired
    private IEntidadService iEntidadService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody EntidadDTO entidadDTO){
        ModelMapper m= new ModelMapper();
        Entidad entidad = m.map(entidadDTO, Entidad.class);
        iEntidadService.insert(entidad);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody EntidadDTO entidadDTO){
        ModelMapper m= new ModelMapper();
        Entidad entidad = m.map(entidadDTO, Entidad.class);
        iEntidadService.insert(entidad);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        iEntidadService.delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<EntidadDTO> listar(){
        return iEntidadService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,EntidadDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/cantidadsospechosos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<SospechosoEntidadDTO> cantidaddesospechososporentidad(){
        List<String[]> lista = iEntidadService.SospechososPorEntidad();
        List<SospechosoEntidadDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            SospechosoEntidadDTO dto =  new SospechosoEntidadDTO();
            dto.setNamesEntidad(data[0]);
            dto.setCantidadSospechosos(Integer.parseInt(data[1]));
            listadto.add(dto);
        }
        return listadto;
    }

}
