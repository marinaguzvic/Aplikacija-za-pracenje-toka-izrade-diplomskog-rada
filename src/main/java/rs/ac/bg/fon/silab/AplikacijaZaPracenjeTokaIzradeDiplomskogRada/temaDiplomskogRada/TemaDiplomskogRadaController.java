/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.temaDiplomskogRada;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class TemaDiplomskogRadaController {
    @Autowired
    private TemaDiplomskogRadaService temaDiplomskogRadaService;

    @RequestMapping("/temadiplomskogradas")
    public List<TemaDiplomskogRadaDTO> getAllTemaDiplomskogRadas() {
        return temaDiplomskogRadaService.getAllTeme();
    }
    
    @RequestMapping("/temadiplomskogradas/search/{nazivTeme}")
    public List<TemaDiplomskogRadaDTO> getTemaDiplomskogRadasByNazivTeme(@PathVariable String nazivTeme){
        return temaDiplomskogRadaService.getTemaDiplomskogRadasByNazivTeme(nazivTeme);
    }

    @RequestMapping("/temadiplomskogradas/{id}")
    public TemaDiplomskogRadaDTO getTemaDiplomskogRada(@PathVariable String id) throws Exception {
        return temaDiplomskogRadaService.getTemaDiplomskogRada(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/temadiplomskogradas")
    public TemaDiplomskogRadaDTO addTemaDiplomskogRada(@RequestBody TemaDiplomskogRadaDTO tema) throws Exception {
        return temaDiplomskogRadaService.addTemaDiplomskogRada(tema);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/temadiplomskogradas/{id}")
    public TemaDiplomskogRadaDTO updateTemaDiplomskogRada(@RequestBody TemaDiplomskogRadaDTO tema,@PathVariable String id) throws Exception {
        tema.setTemaId(Long.parseLong(id));
        return temaDiplomskogRadaService.updateTemaDiplomskogRada(tema);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/temadiplomskogradas/{id}")
    public void deleteTemaDiplomskogRada(@PathVariable String id) throws Exception {
        
        temaDiplomskogRadaService.deleteTemaDiplomskogRada(id);
    }
    
    @RequestMapping("/temadiplomskogradas/free")
    public List<TemaDiplomskogRadaDTO> getFreeTemaDiplomskogRadas() {
        return temaDiplomskogRadaService.getFreeTeme();
    }
}
