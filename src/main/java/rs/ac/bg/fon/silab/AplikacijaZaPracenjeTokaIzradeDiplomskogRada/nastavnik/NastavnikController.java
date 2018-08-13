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
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DiplomskiRad;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class NastavnikController {
    @Autowired
    private NastavnikService nastavnikService;
    @Autowired 
    GenericMapper mapper;

    @RequestMapping("/nastavniks")
    public List<NastavnikDTO> getAllNastavniks() {
        return nastavnikService.getAllNastavniks();
    }

    @RequestMapping("/nastavniks/{id}")
    public NastavnikDTO getNastavnik(@PathVariable String id) {
        return nastavnikService.getNastavnik(id);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/nastavniks/{id}")
//    public NastavnikDTO addNastavnik(@RequestBody NastavnikDTO nastavnik) {
//        return nastavnikService.addNastavnik(nastavnik);
//    }
//    
//    @RequestMapping(method = RequestMethod.PUT, value = "/nastavniks/{id}")
//    public NastavnikDTO updateNastavnik(@RequestBody NastavnikDTO nastavnik,@PathVariable String id) {
//        return nastavnikService.updateNastavnik(nastavnik);
//    }
//    
//    @RequestMapping(method = RequestMethod.DELETE,value = "/nastavniks/{id}")
//    public void deleteNastavnik(@PathVariable String id) throws Exception {
//        nastavnikService.deleteNastavnik(id);
//    }
    
    @RequestMapping("/nastavniks/{id}/diplomskirads")
    public List<DiplomskiRadDTO> getDiplomskiRadsForNastavnik(@PathVariable String id){
      return nastavnikService.getDiplomskiRadsForNastavnik(id);
        
    }
}
