/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nalog;

import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Radnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NalogDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class NalogService {

    @Autowired
    NalogRepository nalogRepository;
    @Autowired
    GenericMapper mapper;

    List<Nalog> getAllNalogs() {
        List<Nalog> nalogs = new ArrayList<>();
        nalogRepository.findAll().forEach(nalogs::add);
        return nalogs;
    }

    Nalog getNalog(String id) {
        return nalogRepository.findById(Long.parseLong(id)).get();
    }

    void addNalog(Nalog nalog) {
        nalogRepository.save(nalog);
    }

    void updateNalog(Nalog nalog) {
        nalogRepository.save(nalog);
    }

    void deleteNalog(String id) {
        nalogRepository.deleteById(Long.parseLong(id));
    }

    ClanSistemaDTO authenticate(NalogDTO nalogDTO) throws Exception {
        Nalog nalog = mapper.nalogDTOToNalog(nalogDTO);
        Nalog nalog1 = nalogRepository.findByKorisnickoImeAndSifra(nalog.getKorisnickoIme(), nalog.getSifra());
        if (nalog1 != null) {
            if(nalog1.getClanSistema() instanceof Student)
                return mapper.studentToStudentDTO((Student) nalog1.getClanSistema());
            if(nalog1.getClanSistema() instanceof Nastavnik)
                return mapper.nastavnikToNastavnikDTO((Nastavnik) nalog1.getClanSistema());
            if(nalog1.getClanSistema() instanceof Radnik)
                return mapper.radnikToRadnikDTO((Radnik) nalog1.getClanSistema());
            else return mapper.clanSistemaToClanSistemaDTO(nalog1.getClanSistema());
        } else {
            throw new Exception("Neuspesna autentifikacija");
        }
        
    }

}
