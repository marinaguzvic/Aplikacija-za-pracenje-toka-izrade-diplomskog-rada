/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.predmet;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class PredmetController {
        @Autowired
    private PredmetService predmetService;

    @RequestMapping("/predmets")
    public List<AbstractDTO> getAllPredmets() {
        return predmetService.getAll(new String[]{});
    }

    @RequestMapping("/predmets/{predmetId}")
    public AbstractDTO getPredmet(@PathVariable String predmetId) {
        return predmetService.get(new String[]{predmetId});
    }

    
}
