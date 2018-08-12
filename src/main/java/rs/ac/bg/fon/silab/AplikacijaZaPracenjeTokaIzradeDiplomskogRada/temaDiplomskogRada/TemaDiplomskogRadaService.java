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
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.TemaDiplomskogRadaDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class TemaDiplomskogRadaService {
    
    @Autowired
    TemaDiplomskogRadaRepository temaDiplomskogRadaRepository;
    @Autowired
    GenericMapper mapper;
            

    public List<TemaDiplomskogRadaDTO> getAllTeme() {
        List<TemaDiplomskogRada> teme = new ArrayList<>();
        temaDiplomskogRadaRepository.findAll().forEach(teme::add);
        List<TemaDiplomskogRadaDTO> temaDTOs = new ArrayList<>();
        for (TemaDiplomskogRada temaDiplomskogRada : teme) {
            temaDTOs.add(mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRada));
        }
        return temaDTOs;
    }

    public TemaDiplomskogRadaDTO getTemaDiplomskogRada(String id) throws Exception {
        try {
            return mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRadaRepository.findById(Long.parseLong(id)).get());
        } catch (Exception e) {
            throw new Exception("Ne postoji tema sa ID-jem: " + id);
        }
        
    }

    TemaDiplomskogRadaDTO addTemaDiplomskogRada(TemaDiplomskogRadaDTO tema) {
        return mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRadaRepository.save(mapper.temaDiplomskogRadaDTOToTemaDiplomskogRada(tema)));
    }

    TemaDiplomskogRadaDTO updateTemaDiplomskogRada(TemaDiplomskogRadaDTO tema) {
        return mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRadaRepository.save(mapper.temaDiplomskogRadaDTOToTemaDiplomskogRada(tema)));
    }

    void deleteTemaDiplomskogRada(String id) {
        temaDiplomskogRadaRepository.deleteById(Long.parseLong(id));
    }

    List<TemaDiplomskogRadaDTO> getTemaDiplomskogRadasByNazivTeme(String nazivTeme) {
        List<TemaDiplomskogRada> temas = temaDiplomskogRadaRepository.findByNazivTeme(nazivTeme);
        List<TemaDiplomskogRadaDTO> temaDTOs = new ArrayList<>();
        for (TemaDiplomskogRada tema : temas) {
            temaDTOs.add(mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(tema));
        }
        return temaDTOs;
    }
    
}
