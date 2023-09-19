package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.AntecedentePenalDTO;
import pe.edu.upc.catchthem.entities.AntecedentePenal;
import pe.edu.upc.catchthem.serviceInterfaces.IAntecedentePenalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/antecedentes")
public class AntecedentePenalController {

    @Autowired
    //aS <-> antecedentePenalService
    private IAntecedentePenalService aS;

    @PostMapping
    @PreAuthorize("hasAuthority('POLICIA')")
    public void registrar(@RequestBody AntecedentePenalDTO antecedentePenalDTO){
        ModelMapper m= new ModelMapper();
        AntecedentePenal ap = m.map(antecedentePenalDTO,AntecedentePenal.class);
        aS.insertar(ap);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('POLICIA') or hasAuthority('AGENTE')")
    public List<AntecedentePenalDTO> listar(){
        return aS.listar().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,AntecedentePenalDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        aS.eliminar(id);
    }



}
