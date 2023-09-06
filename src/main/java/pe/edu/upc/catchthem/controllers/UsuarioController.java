package pe.edu.upc.catchthem.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.catchthem.dtos.UsuarioDTO;
import pe.edu.upc.catchthem.entities.Usuario;
import pe.edu.upc.catchthem.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @PostMapping
    public void registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto,Usuario.class);
        uS.Insert(u);
    }
    @DeleteMapping("/id")
    public void delete(@PathVariable("id") Integer id) {
        uS.eliminar(id);
    }
    @GetMapping
    public List<UsuarioDTO> listar(){
        return uS.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
