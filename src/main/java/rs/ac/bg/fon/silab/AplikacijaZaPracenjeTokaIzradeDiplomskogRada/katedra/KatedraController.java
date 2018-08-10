/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.katedra;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class KatedraController {
        @Autowired
    private KatedraService katedraService;

    @RequestMapping("/katedras")
    public List<Katedra> getAllKatedras() {
        return katedraService.getAllKatedras();
    }

    @RequestMapping("/katedras/{katedraId}")
    public Katedra getKatedra(@PathVariable String katedraId) {
        return katedraService.getKatedra(katedraId);
    }

    
}
