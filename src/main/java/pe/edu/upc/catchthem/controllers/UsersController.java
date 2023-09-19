package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.ActasporPoliciaDTO;
import pe.edu.upc.catchthem.dtos.AntecedentesporSospechosoDTO;
import pe.edu.upc.catchthem.dtos.UsersDTO;
import pe.edu.upc.catchthem.entities.Users;
import pe.edu.upc.catchthem.serviceInterfaces.IUsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService uS;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void registrar(@RequestBody UsersDTO dto){
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto,Users.class);
        uS.insert(u);
    }
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UsersDTO> listar(){
        return uS.listar().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        uS.eliminar(id);
    }

    @GetMapping("/cantidadActasPorPolicia")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ActasporPoliciaDTO> cantidadActasPorPolicia(){
        List<String[]> lista = uS.ActasporPolicia();
        List<ActasporPoliciaDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            ActasporPoliciaDTO dto =  new ActasporPoliciaDTO();
            dto.setNamePolicia(data[0]);
            dto.setCantidadActas(Integer.parseInt(data[1]));
            listadto.add(dto);
        }
        return listadto;
    }
}
