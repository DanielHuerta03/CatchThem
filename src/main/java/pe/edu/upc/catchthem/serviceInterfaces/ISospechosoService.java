package pe.edu.upc.catchthem.serviceinterfaces;

import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;

import java.time.LocalDate;
import java.util.List;

public interface ISospechosoService {

    //HU25: REGISTRAR SOSPECHOSO
    //HU24: CAMBIAR ESTADO
    public void insert(Sospechoso sospechoso);

    //TODO podría incluirse como HU... no hay una que diga sobre eliminar sospechoso.
    //public void delete(int idSospechoso);


    //HU31: ACCEDER A INFORMACION ESPECIFICA
    public List<Sospechoso>findSospechosoByEntidad(Entidad entidad);

    //HU30: FILTRAR SOSPECHOSO POR FECHA
    public List<Sospechoso>findSospechosoByFecha_registro(LocalDate fecha);


}
