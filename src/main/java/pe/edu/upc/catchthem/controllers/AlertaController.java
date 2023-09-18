package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.AlertaDTO;
import pe.edu.upc.catchthem.entities.Alerta;
import pe.edu.upc.catchthem.serviceInterfaces.IAlertaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private IAlertaService alertaService;

    @PostMapping
    @PreAuthorize("hasRole('POLICIA') or hasRole('AGENTE')")
    public void ingresar(@RequestBody AlertaDTO alertaDTO){
        ModelMapper m=new ModelMapper();
        Alerta alerta=m.map(alertaDTO,Alerta.class);
        alertaService.ingresar(alerta);
    }

    @GetMapping
    @PreAuthorize("hasRole('POLICIA') or hasRole('AGENTE')")
    public List<AlertaDTO> listar(){
        return alertaService.listar().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x,AlertaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){
        alertaService.eliminar(id);
    }

    @GetMapping("/Alertasporubicacion")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<String[]> CantidadAlertasPorUbicacion() {
        List<String[]> listadto = alertaService.CantidadAlertasPorUbicacion();
        return listadto;
    }
}
