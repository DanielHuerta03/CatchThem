package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.SospechosoDTO;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.serviceInterfaces.ISospechosoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @PutMapping
    public void modificar(@RequestBody SospechosoDTO sospechosoDTO){
        ModelMapper m= new ModelMapper();
        Sospechoso ap = m.map(sospechosoDTO, Sospechoso.class);
        iSospechosoService.insert(ap);
    }

    @DeleteMapping("/{id}")
    public void  delete(@PathVariable("id") Integer id){
        iSospechosoService.delete(id);
    }

    @GetMapping
    public List<SospechosoDTO> listar(){
        return iSospechosoService.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SospechosoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/buscarfecha")
    public List<SospechosoDTO> buscarfecha(@RequestParam String fecha){
        LocalDate localDate = LocalDate.parse(fecha);
        return iSospechosoService.findSospechosoByFecharegistro(localDate).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SospechosoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/id")
    public SospechosoDTO buscarporid(@RequestParam("id") Integer id){
        ModelMapper m = new ModelMapper();
        SospechosoDTO s = m.map(iSospechosoService.findSospechosoByIdSospechoso(id),SospechosoDTO.class);
        return s;
    }

    @PostMapping("/buscarEntidad")
    public List<SospechosoDTO> buscarporentidad(@RequestBody Entidad entidad){
        return iSospechosoService.findAllByEntidad(entidad).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SospechosoDTO.class);
        }).collect(Collectors.toList());
    }

}
