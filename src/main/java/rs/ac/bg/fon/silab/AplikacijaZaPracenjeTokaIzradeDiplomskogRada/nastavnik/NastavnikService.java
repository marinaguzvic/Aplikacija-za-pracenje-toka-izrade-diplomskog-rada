/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nastavnik;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumTitula;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumZvanje;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;

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
        try {
            nastavnikRepository.deleteById(Long.parseLong(id));
        } catch (IllegalArgumentException iae) {
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
    

    
      BooleanExpression isLike(StringPath property, String searchProperty) {
        return searchProperty != null ? property.contains(searchProperty) : Expressions.asBoolean(true).isTrue();
    }

    private BooleanExpression isEq(StringPath property, String searchProperty) {
        return searchProperty != null ? property.eq(searchProperty) : Expressions.asBoolean(true).isTrue();
    }
    
     private BooleanExpression isIn(StringPath property, String[] searchProperty) {
         if(searchProperty.length == 0)return Expressions.asBoolean(true).isTrue();
        return property.in(searchProperty);
    }
     
      private BooleanExpression isIn(EnumPath property, String[] searchProperty) {
          if(searchProperty.length == 0)return Expressions.asBoolean(true).isTrue();
        return property.in((Object[]) searchProperty);
    }
     
    private BooleanExpression isInGodineStudija(NumberPath property, Integer[] searchProperty) {
        return property.in(searchProperty);
    }

    List<NastavnikDTO> getAllNastavniksForKomisija() {
        List<Nastavnik> nastavniks = new ArrayList<>();
        nastavnikRepository.findAll().forEach(nastavniks::add);
        List<NastavnikDTO> nastavnikDTOs = new ArrayList<>();
        for (Nastavnik nastavnik : nastavniks) {
            if(nastavnik.getTitula().equals(EnumTitula.DOCENT) || nastavnik.getTitula().equals(EnumTitula.REDOVNI_PROFESOR) || nastavnik.getTitula().equals(EnumTitula.VANREDNI_PROFESOR)){
                nastavnikDTOs.add(mapper.nastavnikToNastavnikDTO(nastavnik));
            }
        }
        return nastavnikDTOs;
    }

}
