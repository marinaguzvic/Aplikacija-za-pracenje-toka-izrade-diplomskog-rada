/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.diplomskirad;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.komisija.*;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clankomisije.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.ClanDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.DiplomskiRadDatumOdbraneDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.DiplomskiRadOdbraniDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.DiplomskiRadPrijaviDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.DiplomskiRadUnesiKomisijuDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisijePK;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DiplomskiRad;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumStatus;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumUlogaClanaKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Komisija;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nastavnik.NastavnikRepository;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class DiplomskiRadService {

    @Autowired
    DiplomskiRadRepository diplomskiRadRepository;
    @Autowired
    NastavnikRepository nastavnikRepository;
    @Autowired
    GenericMapper mapper;

    List<DiplomskiRad> getAllDiplomskiRads() {
        List<DiplomskiRad> diplomskiRads = new ArrayList<>();
        diplomskiRadRepository.findAll().forEach(diplomskiRads::add);
        return diplomskiRads;
    }

    DiplomskiRadDTO getDiplomskiRadByStudentId(String diplomskiRadId) {
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.findByStudentIdFkClanSistemaId(Long.parseLong(diplomskiRadId)));
    }

//    void addDiplomskiRad(DiplomskiRad diplomskiRad) {
//        diplomskiRadRepository.save(diplomskiRad);
//    }
//
//    void updateDiplomskiRad(DiplomskiRad diplomskiRad) {
//        diplomskiRadRepository.save(diplomskiRad);
//    }
//
//    void deleteDiplomskiRad(String diplomskiRadId) {
//        diplomskiRadRepository.deleteById(Long.parseLong(diplomskiRadId));
//    }
    DiplomskiRadDTO prijavi(DiplomskiRadPrijaviDTO diplomskiRadPrijaviDTO) throws Exception {
        DiplomskiRad diplomskiRad = mapper.diplomskiRadPrijaviDTOToDiplomskiRad(diplomskiRadPrijaviDTO);
        validatePrijavi(diplomskiRad);
        diplomskiRad.setDatumPrijave(new Date());
        diplomskiRad.setStatus(EnumStatus.PRIJAVLJEN);
        diplomskiRad = diplomskiRadRepository.save(diplomskiRad);
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRad);
    }

    private void validatePrijavi(DiplomskiRad diplomskiRad) throws Exception {
        DiplomskiRad diplomskiRad1 = diplomskiRadRepository.findByStudentIdFkClanSistemaId(diplomskiRad.getStudentIdFk().getClanSistemaId());
        if (diplomskiRad1 != null) {
            throw new Exception("Diplomski rad za datog studenta vec postoji u bazi");
        }
        if (diplomskiRad.getStudentIdFk() == null) {
            throw new Exception("Ne moze se prijaviti diplomski rad, nije prosledjen student");
        }
        if (diplomskiRad.getTemaIdFk() == null) {
            throw new Exception("Ne moze se prijaviti diplomski rad, nije prosledjena tema");
        }
    }

    DiplomskiRadDTO odobri(String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad;
        try {
            diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        } catch (Exception e) {
            throw new Exception("Diplomski rad sa ID-jem: " + diplomskiRadId + " ne postoji u bazi");
        }
        if (diplomskiRad.getStatus() != EnumStatus.PRIJAVLJEN) {
            throw new Exception("Ne moze se odobriti rad koji nije prijavljen!");
        }
        diplomskiRad.setDatumOdobravanja(new Date());
        diplomskiRad.setStatus(EnumStatus.ODOBREN);
        diplomskiRadRepository.save(diplomskiRad);
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRad);

    }

    DiplomskiRadDTO predaj(String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        if (diplomskiRad.getStatus() != EnumStatus.ODREDJENA_KOMISIJA) {
            throw new Exception("Ne moze se predati rad za koji nije odredjena komisija!");
        }
        if(diplomskiRad.getDokumentCollection().size() < 1)throw new Exception("Nema predatih dokumenata za diplomski rad!");
        diplomskiRad.setDatumPredaje(new Date());
        diplomskiRad.setStatus(EnumStatus.PREDAT);
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));
    }

    DiplomskiRadDTO unesiKomisiju(DiplomskiRadUnesiKomisijuDTO diplomskiRadUnesiKomisijuDTO,String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        //validateKomisija(diplomskiRadUnesiKomisijuDTO, diplomskiRad);
        
        Komisija komisija = new Komisija();
        if (diplomskiRad.getStatus() != EnumStatus.ODOBREN) {
            throw new Exception("Ne moze se uneti komisija za rad koji nije odobren!");
        }
        if (!(diplomskiRadUnesiKomisijuDTO.getClans().size() == 3 || diplomskiRadUnesiKomisijuDTO.getClans().size() == 5)) {
            throw new Exception("Neodgovarajuc broj clanova: " + diplomskiRadUnesiKomisijuDTO.getClans().size());
        }
        int mentor = 0;
        boolean saDrugeKatedre = false;
        Katedra katedra = diplomskiRad.getTemaIdFk().getPredmetIdFk().getKatedraIdFk();
        List<ClanKomisije> clanKomisijes = new ArrayList<>();
        int i = 1;
        for (ClanDTO clan : diplomskiRadUnesiKomisijuDTO.getClans()) {
            ClanKomisije clanKomisije = mapper.clanDTOToClanKomisije(clan);
            clanKomisije.setClanKomisijePK(new ClanKomisijePK(null, i));
            Nastavnik nastavnik;
            try {
                nastavnik = nastavnikRepository.findById(clan.getNastavnik()).get();
                
            } catch (Exception e) {
                throw new Exception("Nastavnik sa datim ID-jem: " + clan.getNastavnik() + " ne postoji u bazi!");
            }
            if (clanKomisije.getUlogaClanaKomisije() == EnumUlogaClanaKomisije.MENTOR) {
                mentor++;
                if (!nastavnik.getKatedraIdFk().equals(katedra)) {
                    throw new Exception("Mentor mora biti sa katedre ciji je i predmet");
                }
            } else if (!nastavnik.getKatedraIdFk().equals(katedra)) {
                saDrugeKatedre = true;
            }
            for (ClanKomisije clanKomisije1 : clanKomisijes) {
                if(clanKomisije.getNastavnikIdFk() == nastavnik)throw new Exception("Ne smeju postojati dva ista nastavnika kao clanovi komisije");
            }
            clanKomisije.setNastavnikIdFk(nastavnik);
            clanKomisije.setKomisija(komisija);
            clanKomisijes.add(clanKomisije);
            i++;
        }
        if(mentor != 1)throw new Exception("U komisiji mora biti tacno jedan mentor!");
        if(!saDrugeKatedre) throw new Exception("U komisiji mora biti barem jedan nastavnik koji nije sa katedre na kojoj je radjen diplomski rad!");
        diplomskiRad.setKomisijaIdFk(komisija);
        diplomskiRad = diplomskiRadRepository.save(diplomskiRad);
        for (ClanKomisije clanKomisije : clanKomisijes) {
            clanKomisije.getClanKomisijePK().setKomisijaIdFk(diplomskiRad.getKomisijaIdFk().getKomisijaId());
        }
        komisija.setClanKomisijeCollection(clanKomisijes);
        diplomskiRad.setStatus(EnumStatus.ODREDJENA_KOMISIJA);
        diplomskiRad.setKomisijaIdFk(komisija);
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));

    }

    DiplomskiRadDTO odrediDatumOdbrane(DiplomskiRadDatumOdbraneDTO diplomskiRadDatumOdbraneDTO,String diplomskiRadId) throws Exception{
        DiplomskiRad diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        
        if (diplomskiRad.getStatus() != EnumStatus.PREDAT || TimeUnit.DAYS.convert((diplomskiRadDatumOdbraneDTO.getDatumOdbrane().getTime() - diplomskiRad.getDatumPredaje().getTime()), TimeUnit.MILLISECONDS) < 15) {
            throw new Exception("Rad moze da se brani po isteku 15 dana od dana predaje!");
        }
        diplomskiRad.setDatumOdbrane(diplomskiRadDatumOdbraneDTO.getDatumOdbrane());
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));
        
    }

    DiplomskiRadDTO odbrani(DiplomskiRadOdbraniDTO diplomskiRadOdbraniDTO, String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        if(diplomskiRad.getDatumOdbrane() == null)throw new Exception("Datum odbrane nije definisan");
        if(diplomskiRadOdbraniDTO.getOcena() <= 5 || diplomskiRadOdbraniDTO.getOcena() > 10)throw new Exception("Ocena iz diplomskog rada mora biti izmedju 6 i 10");
        if(diplomskiRad.getDatumOdbrane().after(new Date()))throw new Exception("Datum odbrane ne sme biti nakon unosa ocene");
        diplomskiRad.setOcena(diplomskiRadOdbraniDTO.getOcena());
        diplomskiRad.setStatus(EnumStatus.ODBRANJEN);
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));
    }

}
