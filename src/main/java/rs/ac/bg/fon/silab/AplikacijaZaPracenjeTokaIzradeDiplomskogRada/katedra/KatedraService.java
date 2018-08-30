/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.katedra;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.service.AbstractService;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class KatedraService extends AbstractService{

    @Autowired
    KatedraRepository katedraRepository;
    @Autowired
    GenericMapper mapper;

    @Override
    public List<AbstractDTO> getAll(String [] ids) {
        List<Katedra> katedras = new ArrayList<>();
        katedraRepository.findAll().forEach(katedras::add);
        List<AbstractDTO> dtos = new ArrayList<>();
        katedras.forEach((katedra) -> {
            dtos.add(mapper.katedraToKatedraDTO(katedra));
        });
        return dtos;
    }

    @Override
    public AbstractDTO get(String [] ids) throws Exception {
        try {
            return mapper.katedraToKatedraDTO(katedraRepository.findById(Long.parseLong(ids[0])).get());
        } catch (Exception e) {
            throw new Exception("Katedra sa datim id-jem: " + ids[0] + " ne postoji u bazi!");
        }
        
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
