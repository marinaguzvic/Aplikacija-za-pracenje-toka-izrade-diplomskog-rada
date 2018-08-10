/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.tipdokumenta;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.predmet.*;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.katedra.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Predmet;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TipDokumenta;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class TipDokumentaService {

    @Autowired
    TipDokumentaRepository tipDokumentaRepository;

    List<TipDokumenta> getAllTipDokumentas() {
        List<TipDokumenta> tipDokumentas = new ArrayList<>();
        tipDokumentaRepository.findAll().forEach(tipDokumentas::add);
        return tipDokumentas;
    }

    TipDokumenta getTipDokumenta(String tipDokumentaId) {
        return tipDokumentaRepository.findById(Long.parseLong(tipDokumentaId)).get();
    }

}
