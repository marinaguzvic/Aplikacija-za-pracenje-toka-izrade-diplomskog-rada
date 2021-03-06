/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.diplomskirad;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumStatus;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumUlogaClanaKomisije;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanKaKlijentuDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDatumOdbraneDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadOdbraniDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadPrijaviDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadSearchDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadUnesiKomisijuDTO;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class DiplomskiRadController {

    @Autowired
    private DiplomskiRadService diplomskiRadService;

    @RequestMapping("/diplomskirads")
    public List<AbstractDTO> getAllDiplomskiRads() {
        return diplomskiRadService.getAll(new String[]{});
    }

    @RequestMapping("/diplomskirads/{studentId}")
    public AbstractDTO get(@PathVariable String studentId) {
        return diplomskiRadService.get(new String[]{studentId});
    }

    @RequestMapping("/diplomskiradsbyid/{id}")
    public DiplomskiRadDTO getDiplomskiRadById(@PathVariable String id) {
        return diplomskiRadService.getDiplomskiRad(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/diplomskirads/prijavi")
    public DiplomskiRadDTO prijavi(@RequestBody DiplomskiRadPrijaviDTO diplomskiRadPrijaviDTO) throws Exception {
        return diplomskiRadService.prijavi(diplomskiRadPrijaviDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/diplomskirads/{diplomskiRadId}/odobri")
    public DiplomskiRadDTO odobri(@PathVariable String diplomskiRadId) throws Exception {
        return diplomskiRadService.odobri(diplomskiRadId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/diplomskirads/{diplomskiRadId}/unesikomisiju")
    public DiplomskiRadDTO unesiKomisiju(@RequestBody DiplomskiRadUnesiKomisijuDTO diplomskiRadUnesiKomisijuDTO, @PathVariable String diplomskiRadId) throws Exception {
        return diplomskiRadService.unesiKomisiju(diplomskiRadUnesiKomisijuDTO, diplomskiRadId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/diplomskirads/{diplomskiRadId}/predaj")
    public DiplomskiRadDTO predaj(@PathVariable String diplomskiRadId) throws Exception {
        return diplomskiRadService.predaj(diplomskiRadId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/diplomskirads/{diplomskiRadId}/odbrani")
    public DiplomskiRadDTO odbrani(@RequestBody DiplomskiRadOdbraniDTO diplomskiRadOdbraniDTO, @PathVariable String diplomskiRadId) throws Exception {
        return diplomskiRadService.odbrani(diplomskiRadOdbraniDTO, diplomskiRadId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/diplomskirads/{diplomskiRadId}/odredidatumodbrane")
    public DiplomskiRadDTO odrediDatumOdbrane(@RequestBody DiplomskiRadDatumOdbraneDTO diplomskiRadDatumOdbraneDTO, @PathVariable String diplomskiRadId) throws Exception {
        return diplomskiRadService.odrediDatumOdbrane(diplomskiRadDatumOdbraneDTO, diplomskiRadId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/diplomskirads/search")
    public List<AbstractDTO> searchDiplomskiRads(@RequestBody DiplomskiRadSearchDTO diplomskiRadSearchDTO) {
        return diplomskiRadService.search(diplomskiRadSearchDTO);
    }

    @RequestMapping("/diplomskirads/statuses")
    public List<String> getStatuses() {
        List<String> statuses = new ArrayList<>();
        for (EnumStatus value : EnumStatus.values()) {
            statuses.add(value.toString());
        }
        return statuses;
    }

    @RequestMapping("/diplomskirads/ulogas")
    public List<String> getUlogas() {
        List<String> ulogas = new ArrayList<>();
        for (EnumUlogaClanaKomisije value : EnumUlogaClanaKomisije.values()) {
            ulogas.add(value.toString());
        }
        return ulogas;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/diplomskirads/{diplomskiRadId}/promeniclana")
    public DiplomskiRadDTO promeniClanaKomisije(@RequestBody ClanKaKlijentuDTO clanDTO, @PathVariable String diplomskiRadId) throws Exception {
        return diplomskiRadService.promeniClanaKomisije(clanDTO,diplomskiRadId);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/diplomskirads/{id}")
    public AbstractDTO delete(@PathVariable String id) throws Exception{
        return diplomskiRadService.delete(new String[]{id});
    }
}
