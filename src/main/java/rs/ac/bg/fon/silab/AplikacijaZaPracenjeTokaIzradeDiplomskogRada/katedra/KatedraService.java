/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.katedra;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class KatedraService {

    @Autowired
    KatedraRepository katedraRepository;



   

    List<Katedra> getAllKatedras() {
        List<Katedra> katedras = new ArrayList<>();
        katedraRepository.findAll().forEach(katedras::add);
        return katedras;
    }

    Katedra getKatedra(String katedraId) {
        return katedraRepository.findById(Long.parseLong(katedraId)).get();
    }

}
