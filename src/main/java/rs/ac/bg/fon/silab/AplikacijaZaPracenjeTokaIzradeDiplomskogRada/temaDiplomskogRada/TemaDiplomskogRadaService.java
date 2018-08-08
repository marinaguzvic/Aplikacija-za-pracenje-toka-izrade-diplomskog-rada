/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.temaDiplomskogRada;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class TemaDiplomskogRadaService {
    
    @Autowired
    TemaDiplomskogRadaRepository temaDiplomskogRadaRepository;

    public List<TemaDiplomskogRada> getAllTeme() {
        List<TemaDiplomskogRada> teme = new ArrayList<>();
        temaDiplomskogRadaRepository.findAll().forEach(teme::add);
        return teme;
    }

    public TemaDiplomskogRada getTemaDiplomskogRada(String id) {
        return temaDiplomskogRadaRepository.findById(Long.parseLong(id)).get();
    }

    void addTemaDiplomskogRada(TemaDiplomskogRada tema) {
        temaDiplomskogRadaRepository.save(tema);
    }

    void updateTemaDiplomskogRada(TemaDiplomskogRada tema) {
        temaDiplomskogRadaRepository.save(tema);
    }

    void deleteTemaDiplomskogRada(String id) {
        temaDiplomskogRadaRepository.deleteById(Long.parseLong(id));
    }
    
}
