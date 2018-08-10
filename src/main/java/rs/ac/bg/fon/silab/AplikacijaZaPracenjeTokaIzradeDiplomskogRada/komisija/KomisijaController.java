/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.komisija;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clankomisije.*;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nalog.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Komisija;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class KomisijaController {
        @Autowired
    private KomisijaService komisijaService;

    @RequestMapping("/komisijas")
    public List<Komisija> getAllKomisijas() {
        return komisijaService.getAllKomisijas();
    }

    @RequestMapping("/komisijas/{komisijaId}")
    public Komisija getKomisija(@PathVariable String komisijaId) {
        return komisijaService.getKomisija(komisijaId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/komisijas")
    public void addKomisija(@RequestBody Komisija komisija) {
        komisijaService.addKomisija(komisija);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/komisijas/{komisijaId}")
    public void updateKomisija(@RequestBody Komisija komisija) {
        komisijaService.updateKomisija(komisija);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/komisijas/{komisijaId}")
    public void deleteKomisija(@PathVariable String komisijaId) {
        komisijaService.deleteKomisija(komisijaId);
    }
}
