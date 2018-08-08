/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nastavnik;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class NastavnikController {
    @Autowired
    private NastavnikService nastavnikService;

    @RequestMapping("/nastavniks")
    public List<Nastavnik> getAllNastavniks() {
        return nastavnikService.getAllNastavniks();
    }

    @RequestMapping("/nastavniks/{id}")
    public Nastavnik getNastavnik(@PathVariable String id) {
        return nastavnikService.getNastavnik(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/nastavniks/{id}")
    public void addNastavnik(@RequestBody Nastavnik nastavnik) {
        nastavnikService.addNastavnik(nastavnik);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/nastavniks/{id}")
    public void updateNastavnik(@RequestBody Nastavnik nastavnik,@PathVariable String id) {
        nastavnikService.updateNastavnik(nastavnik);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/nastavniks/{id}")
    public void deleteNastavnikStudent(@PathVariable String id) {
        nastavnikService.deleteNastavnik(id);
    }
}
