package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.catchthem.entities.AntecedentePenal;

import java.util.List;

public interface IAntecedentePenalRepository extends JpaRepository<AntecedentePenal,Integer> {

    List<AntecedentePenal> findAntecedentePenalBySospechoso(Integer id_sospechoso);
}
