package pe.edu.upc.catchthem.serviceinterfaces;

import pe.edu.upc.catchthem.entities.ActasInterrogatorio;

import java.util.List;

public interface IActaInterrogatorioService {

    public void insertar(ActasInterrogatorio actasInterrogatorio);
    public List<ActasInterrogatorio> listar();
    public void eliminar(int idActa);
}
