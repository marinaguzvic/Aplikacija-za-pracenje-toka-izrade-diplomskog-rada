/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.predmet;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.katedra.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Predmet;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class PredmetController {
        @Autowired
    private PredmetService predmetService;

    @RequestMapping("/predmets")
    public List<Predmet> getAllPredmets() {
        return predmetService.getAllPredmets();
    }

    @RequestMapping("/predmets/{predmetId}")
    public Predmet getPredmet(@PathVariable String predmetId) {
        return predmetService.getPredmet(predmetId);
    }

    
}
