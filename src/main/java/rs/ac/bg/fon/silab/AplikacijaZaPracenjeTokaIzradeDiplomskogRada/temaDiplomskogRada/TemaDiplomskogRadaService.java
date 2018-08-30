/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.temaDiplomskogRada;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.service.AbstractService;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class TemaDiplomskogRadaService extends AbstractService{

    @Autowired
    TemaDiplomskogRadaRepository temaDiplomskogRadaRepository;
    @Autowired
    GenericMapper mapper;

    @Override
    public List<AbstractDTO> getAll(String [] ids) {
        List<TemaDiplomskogRada> teme = new ArrayList<>();
        temaDiplomskogRadaRepository.findAll().forEach(teme::add);
        List<AbstractDTO> temaDTOs = new ArrayList<>();
        teme.forEach((temaDiplomskogRada) -> {
            temaDTOs.add(mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRada));
        });
        return temaDTOs;
    }

    @Override
    public AbstractDTO get(String [] ids) throws Exception {
        try {
            return mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRadaRepository.findById(Long.parseLong(ids[0])).get());
        } catch (Exception e) {
            throw new Exception("Ne postoji tema sa ID-jem: " + ids[0]);
        }

    }

    /**
     *
     * @param dto
     * @param ids
     * @return
     * @throws Exception
     */
    @Override
    public AbstractDTO add(AbstractDTO dto, String [] ids) throws Exception {
        TemaDiplomskogRadaDTO tema = (TemaDiplomskogRadaDTO)dto;
        if (tema.getNazivTeme() == null || tema.getNazivTeme().length() < 10) {
            throw new Exception("Naziv teme nije ispravan");
        }
        if (tema.getOpisTeme() == null || tema.getOpisTeme().length() < 10) {
            throw new Exception("Opis teme nije ispravan");
        }
        return mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRadaRepository.save(mapper.temaDiplomskogRadaDTOToTemaDiplomskogRada(tema)));
    }

    @Override
    public AbstractDTO update(AbstractDTO dto, String [] ids) throws Exception {
        TemaDiplomskogRadaDTO tema = (TemaDiplomskogRadaDTO)dto;
        tema.setTemaId(Long.parseLong(ids[0]));
        try {
            TemaDiplomskogRada t = temaDiplomskogRadaRepository.findById(tema.getTemaId()).get();

            if (tema.getNazivTeme() == null || tema.getNazivTeme().length() < 10) {
                throw new Exception("Naziv teme nije ispravan");
            }
            if (tema.getOpisTeme() == null || tema.getOpisTeme().length() < 10) {
                throw new Exception("Opis teme nije ispravan");
            }
            return mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRadaRepository.save(mapper.temaDiplomskogRadaDTOToTemaDiplomskogRada(tema)));
        } catch (Exception e) {
            throw new Exception("Tema sa id-jem: " + tema.getTemaId() + " ne postoji");
        }

    }

    @Override
    public AbstractDTO delete(String [] ids) throws Exception {
        TemaDiplomskogRada tema;
        try {
            tema = temaDiplomskogRadaRepository.findById(Long.parseLong(ids[0])).get();
            if(tema == null) throw new Exception();
        } catch (Exception e) {
            throw new Exception("Tema se ne moze obrisati jer ne postoji u bazi");
        }
        if (tema.getDiplomskiRad() != null) {
            throw new Exception("Tema se ne moze obrisati jer ima prijavljen diplomski rad.");
        }
        temaDiplomskogRadaRepository.deleteById(Long.parseLong(ids[0]));
        return mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(tema);
    }

    List<TemaDiplomskogRadaDTO> getTemaDiplomskogRadasByNazivTeme(String nazivTeme) {
        List<TemaDiplomskogRada> temas = temaDiplomskogRadaRepository.findByNazivTeme(nazivTeme);
        List<TemaDiplomskogRadaDTO> temaDTOs = new ArrayList<>();
        temas.forEach((tema) -> {
            temaDTOs.add(mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(tema));
        });
        return temaDTOs;
    }

    List<TemaDiplomskogRadaDTO> getFreeTeme() {
        List<TemaDiplomskogRada> temas = new ArrayList<>();
        temaDiplomskogRadaRepository.findAll().forEach(temas::add);
        List<TemaDiplomskogRadaDTO> temaDTOs = new ArrayList<>();
        temas.forEach((tema) -> {
            if(tema.getDiplomskiRad() == null)
            temaDTOs.add(mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(tema));
        });
        return temaDTOs;
    }

    @Override
    public List<AbstractDTO> search(AbstractDTO search) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
