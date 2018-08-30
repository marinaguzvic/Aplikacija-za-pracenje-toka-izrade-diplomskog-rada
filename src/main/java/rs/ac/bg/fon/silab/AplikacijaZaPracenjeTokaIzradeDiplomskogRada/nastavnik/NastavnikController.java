/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nastavnik;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;

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
    public List<AbstractDTO> getAllNastavniks() {
        return nastavnikService.getAll(new String[]{});
    }
    
    @RequestMapping("/nastavniks/komisija")
    public List<NastavnikDTO> getAllNastavniksForKomisija() {
        return nastavnikService.getAllNastavniksForKomisija();
    }

    @RequestMapping("/nastavniks/{id}")
    public AbstractDTO getNastavnik(@PathVariable String id) {
        return nastavnikService.get(new String[]{id});
    }
    
    @RequestMapping("/nastavniks/{id}/diplomskirads")
    public List<DiplomskiRadDTO> getDiplomskiRadsForNastavnik(@PathVariable String id){
      return nastavnikService.getDiplomskiRadsForNastavnik(id);
        
    }
}
