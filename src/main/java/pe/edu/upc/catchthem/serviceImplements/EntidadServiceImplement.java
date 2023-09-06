package pe.edu.upc.catchthem.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.Entidad;
import pe.edu.upc.catchthem.repositories.IEntidadRepository;
import pe.edu.upc.catchthem.serviceInterfaces.IEntidadService;

import java.util.List;
@Service
public class EntidadServiceImplement implements IEntidadService {

    @Autowired
    //eR<-> entidadRepository
    private IEntidadRepository eR;
    @Override
    public void insertar(Entidad entidad) {
        eR.save(entidad);
    }

    @Override
    public List<Entidad> listar() {
        return eR.findAll();
    }

    @Override
    public void eliminar(int idEntidad) {
        eR.deleteById(idEntidad);
    }
}
