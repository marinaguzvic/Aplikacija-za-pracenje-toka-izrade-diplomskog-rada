/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dokument;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.diplomskirad.DiplomskiRadRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Dokument;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DokumentPK;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumStatus;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.service.AbstractService;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class DokumentService extends AbstractService{

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
    public Dokument getDokument(String [] ids) throws Exception {
        return dokumentRepository.findById(new DokumentPK(Long.parseLong(ids[0]), Integer.parseInt(ids[1]))).orElseThrow(() -> new Exception("Dokument nije pronadjen"));
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

    @Override
    public AbstractDTO delete(String [] ids) throws Exception {
        Dokument dokument;
        try {
            dokument = dokumentRepository.findById(new DokumentPK(Long.parseLong(ids[0]), Integer.parseInt(ids[1]))).get();
        } catch (Exception e) {
            throw new Exception("Ne postoji dokument pod datim url-om");
        }
        if(dokument.getDiplomskiRad().getStatus() != EnumStatus.ODREDJENA_KOMISIJA)throw new Exception("Više nije dozvoljeno brisanje dokumenta za diplomski rad");
        try {
            dokumentRepository.deleteById(new DokumentPK(Long.parseLong(ids[0]), Integer.parseInt(ids[1])));
        } catch (Exception e) {
            throw new Exception("Brisanje dokumenta nije uspelo");
        }
        return mapper.dokumentToDokumentDTO(dokument);
    }

    @Override
    public List<AbstractDTO> getAll(String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractDTO add(AbstractDTO dto, String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractDTO update(AbstractDTO dto, String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractDTO> search(AbstractDTO search) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractDTO get(String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
