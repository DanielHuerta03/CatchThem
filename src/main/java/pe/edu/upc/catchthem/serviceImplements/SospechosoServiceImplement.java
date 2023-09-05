package pe.edu.upc.catchthem.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.repositories.ISospechosoRepository;
import pe.edu.upc.catchthem.serviceinterfaces.ISospechosoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class SospechosoServiceImplement implements ISospechosoService {

    @Autowired
    private ISospechosoRepository iSospechosoRepository;

    @Override
    public void insert(Sospechoso sospechoso) {
        iSospechosoRepository.save(sospechoso);
    }

    @Override
    public void delete(int idSospechoso) {
        iSospechosoRepository.deleteById(idSospechoso);
    }

    @Override
    public Sospechoso findSospechosoById_sospechoso(Integer id) {
        return iSospechosoRepository.findSospechosoById_sospechoso(id);
    }

    @Override
    public List<Sospechoso> findSospechosoByEntidad(Integer idEntidad) {
        return iSospechosoRepository.findSospechosoByEntidad(idEntidad);
    }


    @Override
    public List<Sospechoso> findSospechosoByFecha_registro(LocalDate fecha) {
        return iSospechosoRepository.findSospechosoByFecha_registro(fecha);
    }
}
