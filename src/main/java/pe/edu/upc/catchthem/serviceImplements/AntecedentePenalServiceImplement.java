package pe.edu.upc.catchthem.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.catchthem.entities.AntecedentePenal;
import pe.edu.upc.catchthem.entities.Sospechoso;
import pe.edu.upc.catchthem.repositories.IAntecedentePenalRepository;
import pe.edu.upc.catchthem.serviceinterfaces.IAntecedentePenalService;

import java.util.List;
@Service
public class AntecedentePenalServiceImplement implements IAntecedentePenalService {

    @Autowired
    //aR<-> antecedentePenalRepository
    private IAntecedentePenalRepository aR;
    @Override
    public void insertar(AntecedentePenal antecedentePenal) {
        aR.save(antecedentePenal);
    }

    @Override
    public List<AntecedentePenal> listar() {
        return aR.findAll();
    }

    @Override
    public void eliminar(int idAntecedente) {
        aR.deleteById(idAntecedente);
    }


}
