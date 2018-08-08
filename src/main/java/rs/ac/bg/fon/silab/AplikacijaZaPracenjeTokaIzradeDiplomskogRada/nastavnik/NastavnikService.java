/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nastavnik;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class NastavnikService {

    @Autowired
    NastavnikRepository nastavnikRepository;

    public List<Nastavnik> getAllNastavniks() {
        List<Nastavnik> nastavniks = new ArrayList<>();
        nastavnikRepository.findAll().forEach(nastavniks::add);
        return nastavniks;
    }

    public Nastavnik getNastavnik(String id) {
        return nastavnikRepository.findById(Long.parseLong(id)).get();
    }

    void addNastavnik(Nastavnik nastavnik) {
        nastavnikRepository.save(nastavnik);
    }

    void updateNastavnik(Nastavnik nastavnik) {
        nastavnikRepository.save(nastavnik);
    }

    void deleteNastavnik(String id) {
        nastavnikRepository.deleteById(Long.parseLong(id));

    }

}
