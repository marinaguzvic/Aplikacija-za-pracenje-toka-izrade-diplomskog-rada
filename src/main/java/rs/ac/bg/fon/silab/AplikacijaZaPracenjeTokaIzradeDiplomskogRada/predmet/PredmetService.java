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
import rs.ac.bg.fon.silab.diplomskiraddtos.PredmetDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class PredmetService {

    @Autowired
    PredmetRepository predmetRepository;
    @Autowired
            GenericMapper mapper;

    List<PredmetDTO> getAllPredmets() {
        List<Predmet> predmets = new ArrayList<>();
        predmetRepository.findAll().forEach(predmets::add);
        List<PredmetDTO> predmetDTOs = new ArrayList<>();
        for (Predmet predmet : predmets) {
            predmetDTOs.add(mapper.predmetToPredmetDTO(predmet));
        }
        return predmetDTOs;
    }

    PredmetDTO getPredmet(String predmetId) {
        return mapper.predmetToPredmetDTO(predmetRepository.findById(Long.parseLong(predmetId)).get());
    }

}
