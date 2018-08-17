/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NalogDTO;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class NalogController {
        @Autowired
    private NalogService nalogService;

//    @RequestMapping("/nalogs")
//    public List<Nalog> getAllNalogs() {
//        return nalogService.getAllNalogs();
//    }
//
//    @RequestMapping("/nalogs/{id}")
//    public Nalog getNalog(@PathVariable String id) {
//        return nalogService.getNalog(id);
//    }
   @RequestMapping(method = RequestMethod.POST, value = "/authenticate")     
    ClanSistemaDTO authenticate(@RequestBody NalogDTO nalog) throws Exception{
       
        return nalogService.authenticate(nalog);
        
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/nalogs")
//    public void addNalog(@RequestBody Nalog nalog) {
//        nalogService.addNalog(nalog);
//    }
//    
//    @RequestMapping(method = RequestMethod.PUT, value = "/nalogs/{id}")
//    public void updateNalog(@RequestBody Nalog nalog,@PathVariable String id) {
//        nalog.getClanSistema().setClanSistemaId(Long.parseLong(id));
//        nalogService.updateNalog(nalog);
//    }
//    
//    @RequestMapping(method = RequestMethod.DELETE,value = "/nalogs/{id}")
//    public void deleteNalog(@PathVariable String id) {
//        nalogService.deleteNalog(id);
//    }
}
