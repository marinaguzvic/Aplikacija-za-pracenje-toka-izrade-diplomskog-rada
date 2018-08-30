/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.predmet;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Predmet;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.service.AbstractService;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.PredmetDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class PredmetService extends AbstractService {

    @Autowired
    PredmetRepository predmetRepository;
    @Autowired
    GenericMapper mapper;

    @Override
    public List<AbstractDTO> getAll(String [] ids) {
        List<Predmet> predmets = new ArrayList<>();
        predmetRepository.findAll().forEach(predmets::add);
        List<AbstractDTO> predmetDTOs = new ArrayList<>();
        predmets.forEach((predmet) -> {
            predmetDTOs.add(mapper.predmetToPredmetDTO(predmet));
        });
        return predmetDTOs;
    }

    @Override
    public AbstractDTO get(String [] ids) {
        return mapper.predmetToPredmetDTO(predmetRepository.findById(Long.parseLong(ids[0])).get());
    }

    @Override
    public AbstractDTO add(AbstractDTO dto, String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractDTO update(AbstractDTO dto, String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractDTO delete(String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractDTO> search(AbstractDTO search) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
