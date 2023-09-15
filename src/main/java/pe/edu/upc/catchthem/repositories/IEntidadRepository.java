package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.Entidad;

import java.util.List;

@Repository
public interface IEntidadRepository extends JpaRepository<Entidad,Integer> {
    void deleteByIdEntidad(Integer id);

    @Query(value = "select e.nombre,count(s.id_sospechoso) from entidad e inner join sospechoso s on e.id_entidad = s.id_entidad group by e.nombre" ,nativeQuery = true)
    public List<String[]> SospechososPorEntidad();
}
