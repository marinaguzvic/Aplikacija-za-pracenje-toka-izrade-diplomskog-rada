/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clankomisije;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanDTO;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class ClanKomisijeController {
        @Autowired
    private ClanKomisijeService clanKomisijeService;

    @RequestMapping("/komisijas/{komisijaId}/clankomisijes")
    public List<ClanDTO> getAllClanKomisije(@PathVariable String komisijaId) {
        return clanKomisijeService.getAllClanKomisijes(komisijaId);
    }

    @RequestMapping("/komisijas/{komisijaId}/clankomisijes/{clanRb}")
    public ClanDTO getClanKomisije(@PathVariable String komisijaId, @PathVariable String clanRb) {
        return clanKomisijeService.getClanKomisije(komisijaId,clanRb);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/komisijas/{komisijaId}/clankomisijes/{clanRb}")
    public ClanDTO addClanKomisije(@RequestBody ClanDTO clanKomisije,@PathVariable String komisijaId,@PathVariable String clanRb) {
        return clanKomisijeService.addClanKomisije(clanKomisije,komisijaId,clanRb);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/komisijas/{komisijaId}/clankomisijes/{clanRb}")
    public ClanDTO updateClanKomisije(@RequestBody ClanDTO clanKomisije,@PathVariable String komisijaId,@PathVariable String clanRb) {
        return clanKomisijeService.updateClanKomisije(clanKomisije,komisijaId,clanRb);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/komisijas/{komisijaId}/clankomisijes/{clanRb}")
    public void deleteClanKomisije(@PathVariable String komisijaId, @PathVariable String clanRb) {
        clanKomisijeService.deleteClanKomisije(komisijaId,clanRb);
    }
}
