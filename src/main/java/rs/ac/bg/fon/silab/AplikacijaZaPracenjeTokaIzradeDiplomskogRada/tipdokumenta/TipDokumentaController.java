/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.tipdokumenta;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Predmet;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TipDokumenta;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class TipDokumentaController {
        @Autowired
    private TipDokumentaService tipDokumentaService;

    @RequestMapping("/tipdokumentas")
    public List<TipDokumenta> getAllTipDokumentas() {
        return tipDokumentaService.getAllTipDokumentas();
    }

    @RequestMapping("/tipdokumentas/{tipDokumentaId}")
    public TipDokumenta getTipDokumenta(@PathVariable String tipDokumentaId) {
        return tipDokumentaService.getTipDokumenta(tipDokumentaId);
    }

    
}
