/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.diplomskirad;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.komisija.*;
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
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DiplomskiRad;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Komisija;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class DiplomskiRadController {
        @Autowired
    private DiplomskiRadService diplomskiRadService;

    @RequestMapping("/diplomskirads")
    public List<DiplomskiRad> getAllDiplomskiRads() {
        return diplomskiRadService.getAllDiplomskiRads();
    }

    @RequestMapping("/diplomskirads/{studentId}")
    public DiplomskiRad getDiplomskiRad(@PathVariable String studentId) {
        return diplomskiRadService.getDiplomskiRadByStudentId(studentId);
    }
    
   

    @RequestMapping(method = RequestMethod.POST, value = "/diplomskirads")
    public void addDiplomskiRad(@RequestBody DiplomskiRad diplomskiRad) {
        diplomskiRadService.addDiplomskiRad(diplomskiRad);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/diplomskirads/{diplomskiRadId}")
    public void updateDiplomskiRad(@RequestBody DiplomskiRad diplomskiRad) {
        diplomskiRadService.updateDiplomskiRad(diplomskiRad);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/diplomskirads/{diplomskiRadId}")
    public void deleteDiplomskiRad(@PathVariable String diplomskiRadId) {
        diplomskiRadService.deleteDiplomskiRad(diplomskiRadId);
    }
}
