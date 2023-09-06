package pe.edu.upc.catchthem.serviceinterfaces;

import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ISospechosoService {

    //HU25: REGISTRAR SOSPECHOSO
    //HU24: CAMBIAR ESTADO
    public void insert(Sospechoso sospechoso);

    public void delete(int idSospechoso);

    public List<Sospechoso> list();

    //HU31: ACCEDER A INFORMACION ESPECIFICA
    public List<Sospechoso> findSospechosoByFecharegistro(LocalDateTime fecha);

    //HU30: FILTRAR SOSPECHOSO POR FECHA
    public Sospechoso findSospechosoByIdSospechoso(Integer id);



}
