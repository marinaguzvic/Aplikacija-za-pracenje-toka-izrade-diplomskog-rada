/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nalog;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class NalogService {
    @Autowired
    NalogRepository nalogRepository;

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
    
}
