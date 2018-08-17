/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanSistema;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DiplomskiRad;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Dokument;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Predmet;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Radnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanKaKlijentuDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanSistemaDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadPrijaviDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NalogDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.NastavnikDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.PredmetDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.RadnikDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.TemaDiplomskogRadaDTO;

/**
 *
 * @author Marina Guzvic
 */
@Mapper(componentModel = "spring")
public interface GenericMapper {

    @Mappings({
        @Mapping(source = "komisijaIdFk.clanKomisijeCollection", target = "clans"),
        @Mapping(source = "dokumentCollection", target = "dokuments"),
        
    })
    DiplomskiRadDTO diplomskiRadToDiplomskiRadDTO(DiplomskiRad diplomskiRad);
    @Mappings({
        @Mapping(source = "studentIdFk", target = "studentIdFk.clanSistemaId"),
        @Mapping(source = "temaIdFk", target = "temaIdFk.temaId")
    })
    DiplomskiRad diplomskiRadPrijaviDTOToDiplomskiRad(DiplomskiRadPrijaviDTO diplomskiRadPrijaviDTO);
//    @Mapping(source = "clans", target = "komisijaIdFk.clanKomisijeCollection")
//    DiplomskiRad diplomskiRadOdbraniDTOToDiplomskiRad(DiplomskiRadOdbraniDTO diplomskiRadOdbraniDTO);
    @Mapping(source = "nastavnikIdFk.clanSistemaId", target = "nastavnik")
    ClanDTO clanKomisijeToClanDTO(ClanKomisije clan);
    @Mapping(source = "nastavnik", target = "nastavnikIdFk.clanSistemaId")
    ClanKomisije clanDTOToClanKomisije(ClanDTO clan);
    
    @Mapping(source = "katedraIdFk.nazivKatedre", target = "katedra")
    NastavnikDTO nastavnikToNastavnikDTO(Nastavnik nastavnik);
    @Mapping(source = "katedra", target = "katedraIdFk.nazivKatedre")
    Nastavnik nastavnikDTOToNastavnik(NastavnikDTO nastavnikDTO);
    
    TemaDiplomskogRadaDTO temaDiplomskogRadaToTemaDiplomskogRadaDTO(TemaDiplomskogRada tema);
    TemaDiplomskogRada temaDiplomskogRadaDTOToTemaDiplomskogRada(TemaDiplomskogRadaDTO tema);
    
    @Mapping(source = "katedraIdFk.nazivKatedre", target = "katedra")
    PredmetDTO predmetToPredmetDTO(Predmet predmet);
    @Mapping(source = "katedra", target = "katedraIdFk.nazivKatedre")
    Predmet predmetDTOToPredmet(PredmetDTO predmet);
    
    StudentDTO studentToStudentDTO(Student student);
    Student studentDTOToStudent(StudentDTO student);
    
    ClanSistema clanSistemaDTOToClanSistema(ClanSistemaDTO clanSistemaDTO);
    ClanSistemaDTO clanSistemaToClanSistemaDTO(ClanSistema clanSistema);
    
    Radnik radnikDTOToRadnik(RadnikDTO radnik);
    RadnikDTO radnikToRadnikDTO(Radnik radnik);
    
    @Mapping(source = "clanKomisijePK.clanKomisijeRb", target = "clanKomisijeRb")
    ClanKaKlijentuDTO clanKomisijeToClanKaKlijentuDTO(ClanKomisije clanKomisije);
    @Mapping(source = "clanKomisijeRb", target = "clanKomisijePK.clanKomisijeRb")
    ClanKomisije clanKomisijeToClanKaKlijentuDTO(ClanKaKlijentuDTO clan);
    
    Nalog nalogDTOToNalog(NalogDTO nalog);
    
    String dokumentToString(Dokument dokument);
}
