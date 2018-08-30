/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dokument;

import java.io.IOException;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clan.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.diplomskirad.DiplomskiRadRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanSistema;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Dokument;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DokumentPK;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class DokumentService{

    @Autowired
    DokumentRepository dokumentRepository;
    @Autowired 
    DiplomskiRadRepository diplomskiRadRepository;
    @Autowired
            GenericMapper mapper;

//    List<Dokument> getAllDokuments(String diplomskiRadId) {
//        return dokumentRepository.findByDokumentPKDiplomskiRadIdFk(Long.parseLong(diplomskiRadId));
//    }
//
    Dokument getDokument(String diplomskiRadId, String dokumentId) throws Exception {
        return dokumentRepository.findById(new DokumentPK(Long.parseLong(diplomskiRadId), Integer.parseInt(dokumentId))).orElseThrow(() -> new Exception("Dokument nije pronadjen"));
//        return dokumentRepository.findById(new DokumentPK(Long.parseLong(diplomskiRadId), Integer.parseInt(dokumentId))).get();
    }

    DiplomskiRadDTO addDokument(MultipartFile file, String diplomskiRadId) throws Exception {
        List<Dokument> dokumenti = dokumentRepository.findByDokumentPKDiplomskiRadIdFk(Long.parseLong(diplomskiRadId));
        int rb = 0;
        for (Dokument dokument : dokumenti) {
            if(dokument.getDokumentPK().getDokumentRb() > rb) rb = dokument.getDokumentPK().getDokumentRb();
        }
        rb++;
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Izvinite! Ime fajla sadrzi nepravilne karaktere " + fileName);
            }
            Dokument dokument = new Dokument(new DokumentPK(Long.parseLong(diplomskiRadId), rb) ,fileName, file.getContentType(), file.getBytes());
            dokumentRepository.save(dokument);
            return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get());
        } catch (Exception ex) {
            throw new Exception("Dokument " + fileName + " ne moze biti sacuvan. Molimo Vas pokusajte opet!", ex);
        }
    }

    void updateDokument(MultipartFile file, String diplomskiRadId, String dokumentId) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new Exception("Izvinite! Ime fajla sadrzi nepravilne karaktere " + fileName);
            }
            Dokument dokument = new Dokument(new DokumentPK(Long.parseLong(diplomskiRadId), Integer.parseInt(dokumentId)),fileName, file.getContentType(), file.getBytes());
            dokumentRepository.save(dokument);
        } catch (Exception ex) {
            throw new Exception("Dokument " + fileName + " ne moze biti sacuvan. Molimo Vas pokusajte opet!", ex);
        }
    }

    void deleteDokument(String diplomskiRadId, String dokumentId) {
        dokumentRepository.deleteById(new DokumentPK(Long.parseLong(diplomskiRadId), Integer.parseInt(dokumentId)));
    }

}
