package pe.edu.upc.catchthem.repositories;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISospechosoRepository extends JpaRepository<Sospechoso,Integer> {


    //mostrar sospechoso para cada entidad (no se si va... sería más general)
    List<Sospechoso>findSospechosoByEntidad(Entidad entidad);

    //HU30
    @Query("SELECT s FROM Sospechoso s WHERE s.fecha_registro=:fecha")
    List<Sospechoso>findSospechosoByFecha_registro(LocalDate fecha);

    //puede ser nuevo HU
    //List<Sospechoso>findSospechosoByFecha_registroBetween(LocalDate fechainicio, LocalDate fechafinal);






}
