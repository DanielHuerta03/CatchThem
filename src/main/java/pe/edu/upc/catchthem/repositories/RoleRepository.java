package pe.edu.upc.catchthem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.catchthem.entities.rol;

@Repository
public interface RoleRepository extends JpaRepository<rol, Long> {

}