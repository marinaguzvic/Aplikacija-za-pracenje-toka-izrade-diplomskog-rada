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
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class KatedraController {
        @Autowired
    private KatedraService katedraService;

    @RequestMapping("/katedras")
    public List<AbstractDTO> getAllKatedras() {
        return katedraService.getAll(new String[]{});
    }

    @RequestMapping("/katedras/{katedraId}")
    public AbstractDTO getKatedra(@PathVariable String katedraId) throws Exception {
        return katedraService.get(new String[]{katedraId});
    }

    
}
