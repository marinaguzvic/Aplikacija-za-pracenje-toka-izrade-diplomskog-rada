/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nastavnik;

import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class NastavnikService {

    @Autowired
    NastavnikRepository nastavnikRepository;
    @Autowired
    GenericMapper mapper;

    public List<NastavnikDTO> getAllNastavniks() {
        List<Nastavnik> nastavniks = new ArrayList<>();
        nastavnikRepository.findAll().forEach(nastavniks::add);
        List<NastavnikDTO> nastavnikDTOs = new ArrayList<>();
        for (Nastavnik nastavnik : nastavniks) {
            nastavnikDTOs.add(mapper.nastavnikToNastavnikDTO(nastavnik));
        }
        return nastavnikDTOs;
    }

    public NastavnikDTO getNastavnik(String id) {
        return mapper.nastavnikToNastavnikDTO(nastavnikRepository.findById(Long.parseLong(id)).get());
    }

    public NastavnikDTO addNastavnik(NastavnikDTO nastavnik) {
        Nastavnik nastavnik1 = nastavnikRepository.save(mapper.nastavnikDTOToNastavnik(nastavnik));
        return mapper.nastavnikToNastavnikDTO(nastavnik1);
    }

    public NastavnikDTO updateNastavnik(NastavnikDTO nastavnik) {
        Nastavnik nastavnik1 = nastavnikRepository.save(mapper.nastavnikDTOToNastavnik(nastavnik));
        return mapper.nastavnikToNastavnikDTO(nastavnik1);
    }

    void deleteNastavnik(String id) throws Exception {
        try{
            nastavnikRepository.deleteById(Long.parseLong(id));
        }catch(IllegalArgumentException iae){
            throw new Exception("Nastavnik sa Id-jem " + id + " ne postoji u bazi");
        }
        

    }

    List<DiplomskiRadDTO> getDiplomskiRadsForNastavnik(String id) {
        Nastavnik nastavnik = nastavnikRepository.findById(Long.parseLong(id)).get();
        List<ClanKomisije> clanKomisijes = nastavnik.getClanKomisijeCollection();
        List<DiplomskiRadDTO> diplomskiRads = new ArrayList<>();
        clanKomisijes.forEach((clanKomisije) -> {
            diplomskiRads.add(mapper.diplomskiRadToDiplomskiRadDTO(clanKomisije.getKomisija().getDiplomskiRadCollection()));
        });
        return diplomskiRads;
    }

}
