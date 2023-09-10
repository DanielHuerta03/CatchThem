package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.Entidad;

@Repository
public interface IEntidadRepository extends JpaRepository<Entidad,Integer> {
    void deleteByIdEntidad(Integer id);
}
