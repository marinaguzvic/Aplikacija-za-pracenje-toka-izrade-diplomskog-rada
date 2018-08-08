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
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class TemaDiplomskogRadaController {
    @Autowired
    private TemaDiplomskogRadaService temaDiplomskogRadaService;

    @RequestMapping("/temadiplomskogradas")
    public List<TemaDiplomskogRada> getAllTemaDiplomskogRadas() {
        return temaDiplomskogRadaService.getAllTeme();
    }

    @RequestMapping("/temadiplomskogradas/{id}")
    public TemaDiplomskogRada getTemaDiplomskogRada(@PathVariable String id) {
        return temaDiplomskogRadaService.getTemaDiplomskogRada(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/temadiplomskogradas")
    public void addTemaDiplomskogRada(@RequestBody TemaDiplomskogRada tema) {
        temaDiplomskogRadaService.addTemaDiplomskogRada(tema);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/temadiplomskogradas/{id}")
    public void updateCourse(@RequestBody TemaDiplomskogRada tema,@PathVariable String id) {
        tema.setTemaId(Long.parseLong(id));
        temaDiplomskogRadaService.updateTemaDiplomskogRada(tema);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/temadiplomskogradas/{id}")
    public void deleteTemaDiplomskogRada(@PathVariable String id) {
        
        temaDiplomskogRadaService.deleteTemaDiplomskogRada(id);
    }
}
