package pe.edu.upc.catchthem.repositories;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ISospechosoRepository extends JpaRepository<Sospechoso,Integer> {

    List<Sospechoso> findSospechosoByFecharegistro(LocalDateTime fecha);

    Sospechoso findSospechosoByIdSospechoso(Integer id);


}
