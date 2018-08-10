/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.predmet;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.katedra.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Predmet;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class PredmetService {

    @Autowired
    PredmetRepository predmetRepository;

    List<Predmet> getAllPredmets() {
        List<Predmet> predmets = new ArrayList<>();
        predmetRepository.findAll().forEach(predmets::add);
        return predmets;
    }

    Predmet getPredmet(String predmetId) {
        return predmetRepository.findById(Long.parseLong(predmetId)).get();
    }

}
