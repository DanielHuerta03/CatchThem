package pe.edu.upc.catchthem.serviceInterfaces;

import pe.edu.upc.catchthem.entities.Entidad;

import java.util.List;

public interface IEntidadService {

    public void insertar(Entidad entidad);
    public List<Entidad> listar();
    public void eliminar(int idEntidad);
}
