/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.komisija;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clankomisije.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisijePK;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Komisija;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class KomisijaService {

    @Autowired
    KomisijaRepository komisijaRepository;



    List<Komisija> getAllKomisijas() {
        List<Komisija> komisijas = new ArrayList<>();
        komisijaRepository.findAll().forEach(komisijas::add);
        return komisijas;
    }

    Komisija getKomisija(String komisijaId) {
        return komisijaRepository.findById(Long.parseLong(komisijaId)).get();
    }

    void addKomisija(Komisija komisija) {
        komisijaRepository.save(komisija);
    }

    void updateKomisija(Komisija komisija) {
        komisijaRepository.save(komisija);
    }

    void deleteKomisija(String komisijaId) {
        komisijaRepository.deleteById(Long.parseLong(komisijaId));
    }

}
