/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.diplomskirad;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.komisija.*;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clankomisije.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisijePK;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DiplomskiRad;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Komisija;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class DiplomskiRadService {

    @Autowired
    DiplomskiRadRepository diplomskiRadRepository;

    List<DiplomskiRad> getAllDiplomskiRads() {
        List<DiplomskiRad> diplomskiRads = new ArrayList<>();
        diplomskiRadRepository.findAll().forEach(diplomskiRads::add);
        return diplomskiRads;
    }

    DiplomskiRad getDiplomskiRad(String diplomskiRadId) {
        return diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
    }

    DiplomskiRad getDiplomskiRadByStudentId(String studentId) {
        return diplomskiRadRepository.findByStudentIdFkClanSistemaId(Long.parseLong(studentId));
    }

    void addDiplomskiRad(DiplomskiRad diplomskiRad) {
        diplomskiRadRepository.save(diplomskiRad);
    }

    void updateDiplomskiRad(DiplomskiRad diplomskiRad) {
        diplomskiRadRepository.save(diplomskiRad);
    }

    void deleteDiplomskiRad(String diplomskiRadId) {
        diplomskiRadRepository.deleteById(Long.parseLong(diplomskiRadId));
    }

}
