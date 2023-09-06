package pe.edu.upc.catchthem.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Usuario;
import pe.edu.upc.catchthem.repositories.IUsuarioRepository;
import pe.edu.upc.catchthem.serviceinterfaces.IUsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository uR;

    @Override
    public void Insert(Usuario usuario) {
        uR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void eliminar(int idUsuario) {
        uR.deleteById(idUsuario);
    }
}
