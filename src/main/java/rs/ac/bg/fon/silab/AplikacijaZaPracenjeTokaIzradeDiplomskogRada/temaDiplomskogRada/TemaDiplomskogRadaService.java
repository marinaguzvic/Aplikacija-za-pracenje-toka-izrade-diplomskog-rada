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
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;

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

    TemaDiplomskogRadaDTO addTemaDiplomskogRada(TemaDiplomskogRadaDTO tema) throws Exception {
        if (tema.getNazivTeme() == null || tema.getNazivTeme().length() < 10) {
            throw new Exception("Naziv teme nije ispravan");
        }
        if (tema.getOpisTeme() == null || tema.getOpisTeme().length() < 10) {
            throw new Exception("Opis teme nije ispravan");
        }
        return mapper.temaDiplomskogRadaToTemaDiplomskogRadaDTO(temaDiplomskogRadaRepository.save(mapper.temaDiplomskogRadaDTOToTemaDiplomskogRada(tema)));
    }

    TemaDiplomskogRadaDTO updateTemaDiplomskogRada(TemaDiplomskogRadaDTO tema) throws Exception {
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

    void deleteTemaDiplomskogRada(String id) throws Exception {
        TemaDiplomskogRada tema;
        try {
            tema = temaDiplomskogRadaRepository.findById(Long.parseLong(id)).get();
        } catch (Exception e) {
            throw new Exception("Tema se ne moze obrisati jer ne postoji u bazi");

        }
        if (tema.getDiplomskiRad() != null) {
            throw new Exception("Tema se ne moze obrisati jer ima prijavljen diplomski rad.");
        }
        temaDiplomskogRadaRepository.deleteById(Long.parseLong(id));
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

}
