/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clan;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanSistema;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class ClanSistemaController {
    @Autowired
    private ClanSistemaService clanSistemaService;

    @RequestMapping("/clansistemas")
    public List<ClanSistema> getAllClanSistemas() {
        return clanSistemaService.getAllClanSistemas();
    }

    @RequestMapping("/clansistemas/{id}")
    public ClanSistema getClanSistema(@PathVariable String id) {
        return clanSistemaService.getClanSistema(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/clansistemas")
    public void addClanSistema(@RequestBody ClanSistema clanSistema) {
        clanSistemaService.addTemaDiplomskogRada(clanSistema);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/clansistemas/{id}")
    public void updateClanSistema(@RequestBody ClanSistema clanSistema,@PathVariable String id) {
        clanSistemaService.updateClanSistema(clanSistema);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/clansistemas/{id}")
    public void deleteClanSistema(@PathVariable String id) {
        clanSistemaService.deleteClanSistema(id);
    }
}
