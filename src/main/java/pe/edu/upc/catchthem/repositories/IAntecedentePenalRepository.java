package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.AntecedentePenal;

import java.util.List;

@Repository
public interface IAntecedentePenalRepository extends JpaRepository<AntecedentePenal,Integer> {

    List<AntecedentePenal> findAntecedentePenalBySospechoso(Integer id_sospechoso);

    @Query("SELECT " + "SPLIT_PART(a.delito, ' - ', 1) AS delito_comun, " +
            "COUNT(*) AS cantidad_antecedentes " + "FROM " + "AntecedentePenal a " +
            "GROUP BY " + "delito_comun " + "ORDER BY " + "cantidad_antecedentes DESC")
    List<String[]> antecedentesPorDelito();
}
