package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.SospechosoDTO;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.serviceinterfaces.ISospechosoService;

import java.time.LocalDate;
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

    @DeleteMapping("/id")
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


    @GetMapping("/id")
    public SospechosoDTO buscar_sospechoso(@PathVariable("id")Integer id){
        ModelMapper m = new ModelMapper();
        SospechosoDTO s = m.map(iSospechosoService.findSospechosoById_sospechoso(id),SospechosoDTO.class);
        return s;
    }

    @PostMapping("/buscar_fecha")
    public List<SospechosoDTO> listar_por_fecha(@RequestBody LocalDate fecha){
        return iSospechosoService.findSospechosoByFecha_registro(fecha).stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,SospechosoDTO.class);
        }).collect(Collectors.toList());
    }


}
