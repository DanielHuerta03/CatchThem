package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public void Insert(Usuario usuario);
    public List<Usuario> list();
    public void eliminar(int idUsuario);
}
