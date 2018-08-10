/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dokument;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clan.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanSistema;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Dokument;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class DokumentController {
    @Autowired
    private DokumentService dokumentService;

    @RequestMapping("/diplomskirads/{diplomskiRadId}/dokuments")
    public List<Dokument> getAllDokuments(@PathVariable String diplomskiRadId) {
        return dokumentService.getAllDokuments(diplomskiRadId);
    }

    @RequestMapping("/diplomskirads/{diplomskiRadId}/dokuments/{dokumentId}")
    public Dokument getDokument(@PathVariable String diplomskiRadId,@PathVariable String dokumentId) throws Exception {
        return dokumentService.getDokument(diplomskiRadId,dokumentId);
    }
    
    @RequestMapping("/diplomskirads/{diplomskiRadId}/dokuments/{dokumentId}/download")
    public ResponseEntity<Resource> downloadDokument(@PathVariable String diplomskiRadId,@PathVariable String dokumentId) throws Exception {
        Dokument dokument = dokumentService.getDokument(diplomskiRadId,dokumentId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(dokument.getTipDokumenta())).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dokument.getNazivDokumenta() + "\"").body(new ByteArrayResource(dokument.getSadrzajDokumenta()));
    }
    

    @RequestMapping(method = RequestMethod.POST, value = "/diplomskirads/{diplomskiRadId}/dokuments/{dokumentId}")
    public void addDokument(@RequestParam("file") MultipartFile file,@PathVariable String diplomskiRadId,@PathVariable String dokumentId) throws Exception {
        dokumentService.addDokument(file,diplomskiRadId,dokumentId);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/diplomskirads/{diplomskiRadId}/dokuments/{dokumentId}")
    public void updateDokument(@RequestBody  MultipartFile file,@PathVariable String diplomskiRadId,@PathVariable String dokumentId) throws Exception {
        dokumentService.updateDokument(file,diplomskiRadId,dokumentId);
    }

    
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/diplomskirads/{diplomskiRadId}/dokuments/{dokumentId}")
    public void deleteDokument(@PathVariable String diplomskiRadId,@PathVariable String dokumentId) {
        dokumentService.deleteDokument(diplomskiRadId,dokumentId);
    }
}
