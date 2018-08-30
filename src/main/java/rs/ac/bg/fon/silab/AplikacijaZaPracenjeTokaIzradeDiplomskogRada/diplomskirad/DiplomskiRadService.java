/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.diplomskirad;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPAExpressions;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisijePK;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DiplomskiRad;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumStatus;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumTitula;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.EnumUlogaClanaKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Katedra;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Komisija;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nastavnik;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.QClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.QDiplomskiRad;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.nastavnik.NastavnikRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.service.AbstractService;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.student.StudentRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.temaDiplomskogRada.TemaDiplomskogRadaRepository;
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanKaKlijentuDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadDatumOdbraneDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadOdbraniDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadPrijaviDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadSearchDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.DiplomskiRadUnesiKomisijuDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class DiplomskiRadService extends AbstractService{

    @Autowired
    DiplomskiRadRepository diplomskiRadRepository;
    @Autowired
    NastavnikRepository nastavnikRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TemaDiplomskogRadaRepository temaDiplomskogRadaRepository;
    @Autowired
    GenericMapper mapper;

    @Override
    public List<AbstractDTO> getAll(String [] ids) {
        List<DiplomskiRad> diplomskiRads = new ArrayList<>();
        diplomskiRadRepository.findAll().forEach(diplomskiRads::add);
        List<AbstractDTO> dtos = new ArrayList<>();
        diplomskiRads.forEach((diplomskiRad) -> {
            dtos.add(mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRad));
        });
        return dtos;
    }

    @Override
    public AbstractDTO get(String [] ids) {
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.findByStudentIdFkClanSistemaId(Long.parseLong(ids[0])));
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
        diplomskiRad.setDatumPrijave(LocalDate.now());
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
        Student student;
        try {
            student = studentRepository.findById(diplomskiRad.getStudentIdFk().getClanSistemaId()).get();
            diplomskiRad.setStudentIdFk(student);

        } catch (Exception e) {
            throw new Exception("Student sa ID-jem: " + diplomskiRad.getStudentIdFk().getClanSistemaId() + " ne postoji u bazi");
        }

        if (student.getGodinaStudija() != 4) {
            throw new Exception("Ne moze se prijaviti diplomski rad za studenta koji nije na završnoj godini studija");
        }

        if (diplomskiRad.getTemaIdFk() == null) {
            throw new Exception("Ne moze se prijaviti diplomski rad, nije prosledjena tema");
        }
        TemaDiplomskogRada tema;
        try {
            tema = temaDiplomskogRadaRepository.findById(diplomskiRad.getTemaIdFk().getTemaId()).get();
            diplomskiRad.setTemaIdFk(tema);
        } catch (Exception e) {
            throw new Exception("Tema sa datim Id-jem: " + diplomskiRad.getTemaIdFk().getTemaId() + " ne postoji u bazi");
        }

        if (diplomskiRadRepository.findBytemaIdFkTemaId(diplomskiRad.getTemaIdFk().getTemaId()) != null) {
            throw new Exception("Data tema je zauzeta.");
        }

    }

    DiplomskiRadDTO odobri(String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad = null;
        diplomskiRad = validateOdobri(diplomskiRad, diplomskiRadId);
        diplomskiRad.setDatumOdobravanja(LocalDate.now());
        diplomskiRad.setStatus(EnumStatus.ODOBREN);
        diplomskiRadRepository.save(diplomskiRad);
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRad);

    }

    private DiplomskiRad validateOdobri(DiplomskiRad diplomskiRad, String diplomskiRadId) throws Exception {
        try {
            diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        } catch (Exception e) {
            throw new Exception("Diplomski rad sa ID-jem: " + diplomskiRadId + " ne postoji u bazi");
        }
        if (diplomskiRad.getStatus() != EnumStatus.PRIJAVLJEN) {
            throw new Exception("Ne moze se odobriti rad koji nije prijavljen!");
        }
        return diplomskiRad;
    }

    DiplomskiRadDTO predaj(String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        validatePredaj(diplomskiRad);
        diplomskiRad.setDatumPredaje(LocalDate.now());
        diplomskiRad.setStatus(EnumStatus.PREDAT);
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));
    }

    private void validatePredaj(DiplomskiRad diplomskiRad) throws Exception {
        if (diplomskiRad.getStatus() != EnumStatus.ODREDJENA_KOMISIJA) {
            throw new Exception("Ne moze se predati rad za koji nije odredjena komisija!");
        }
        if (diplomskiRad.getDokumentCollection().size() < 1) {
            throw new Exception("Nema predatih dokumenata za diplomski rad!");
        }
    }

    DiplomskiRadDTO unesiKomisiju(DiplomskiRadUnesiKomisijuDTO diplomskiRadUnesiKomisijuDTO, String diplomskiRadId) throws Exception {
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
                nastavnik = nastavnikRepository.findById(clan.getNastavnik().getClanSistemaId()).get();

            } catch (Exception e) {
                throw new Exception("Nastavnik sa datim ID-jem: " + clan.getNastavnik() + " ne postoji u bazi!");
            }
            if (!Arrays.asList(EnumTitula.DOCENT, EnumTitula.REDOVNI_PROFESOR, EnumTitula.VANREDNI_PROFESOR).contains(nastavnik.getTitula())) {
                throw new Exception("Nastavnik koji je u komisiji mora imati titulu docenta, vanrednog ili redovnog profesora");
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
                if (clanKomisije1.getNastavnikIdFk().equals(nastavnik)) {
                    throw new Exception("Ne smeju postojati dva ista nastavnika kao clanovi komisije");
                }
            }
            clanKomisije.setNastavnikIdFk(nastavnik);
            clanKomisije.setKomisija(komisija);
            clanKomisijes.add(clanKomisije);
            i++;
        }
        if (mentor != 1) {
            throw new Exception("U komisiji mora biti tacno jedan mentor!");
        }
        if (!saDrugeKatedre) {
            throw new Exception("U komisiji mora biti barem jedan nastavnik koji nije sa katedre na kojoj je radjen diplomski rad!");
        }
        //komisija.setClanKomisijeCollection(clanKomisijes);
        diplomskiRad.setKomisijaIdFk(komisija);
        diplomskiRad.setStatus(EnumStatus.ODREDJENA_KOMISIJA);
        diplomskiRad = diplomskiRadRepository.save(diplomskiRad);
        
        for (ClanKomisije clanKomisije : clanKomisijes) {
            clanKomisije.getClanKomisijePK().setKomisijaIdFk(diplomskiRad.getKomisijaIdFk().getKomisijaId());
            clanKomisije.setKomisija(diplomskiRad.getKomisijaIdFk());
        }
        diplomskiRad.getKomisijaIdFk().setClanKomisijeCollection(clanKomisijes);
        
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));

    }

    DiplomskiRadDTO odrediDatumOdbrane(DiplomskiRadDatumOdbraneDTO diplomskiRadDatumOdbraneDTO, String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();

//        if (diplomskiRad.getStatus() != EnumStatus.PREDAT || TimeUnit.DAYS.convert((diplomskiRadDatumOdbraneDTO.getDatumOdbrane().getTime() - diplomskiRad.getDatumPredaje().getTime()), TimeUnit.MILLISECONDS) < 15) {
//            throw new Exception("Rad moze da se brani po isteku 15 dana od dana predaje!");
//        }
        diplomskiRad.setDatumOdbrane(LocalDate.parse(diplomskiRadDatumOdbraneDTO.getDatumOdbrane()));
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));

    }

    DiplomskiRadDTO odbrani(DiplomskiRadOdbraniDTO diplomskiRadOdbraniDTO, String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        if (diplomskiRad.getDatumOdbrane() == null) {
            throw new Exception("Datum odbrane nije definisan");
        }
        if (diplomskiRadOdbraniDTO.getOcena() <= 5 || diplomskiRadOdbraniDTO.getOcena() > 10) {
            throw new Exception("Ocena iz diplomskog rada mora biti izmedju 6 i 10");
        }
        if (diplomskiRad.getDatumOdbrane().isAfter(LocalDate.now())) {
            throw new Exception("Datum odbrane ne sme biti nakon unosa ocene");
        }
        diplomskiRad.setOcena(diplomskiRadOdbraniDTO.getOcena());
        diplomskiRad.setStatus(EnumStatus.ODBRANJEN);
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));
    }

    @Override
    public List<AbstractDTO> search(AbstractDTO dto) {
        DiplomskiRadSearchDTO diplomskiRadSearchDTO = (DiplomskiRadSearchDTO)dto;
        List<EnumStatus> statuses = new ArrayList<>();
        if ((diplomskiRadSearchDTO.getStatuses() != null)) {
            for (String statuse : diplomskiRadSearchDTO.getStatuses()) {
                statuses.add(EnumStatus.valueOf(statuse));
            }
        }

        List<EnumUlogaClanaKomisije> uloge = new ArrayList<>();
        if ((diplomskiRadSearchDTO.getUlogaClanaKomisijes() != null)) {
            for (String statuse : diplomskiRadSearchDTO.getUlogaClanaKomisijes()) {
                uloge.add(EnumUlogaClanaKomisije.valueOf(statuse));
            }
        }
        QDiplomskiRad qDiplomskiRad = QDiplomskiRad.diplomskiRad;
        QClanKomisije qClanKomisije = QClanKomisije.clanKomisije;
        Predicate exp = qDiplomskiRad.komisijaIdFk.komisijaId
                .in(JPAExpressions
                        .select(qClanKomisije.clanKomisijePK.komisijaIdFk)
                        .from(qClanKomisije)
                        .where(qClanKomisije.nastavnikIdFk.clanSistemaId.eq(diplomskiRadSearchDTO.getNastavnikId())
                                .and(isIn(qClanKomisije.ulogaClanaKomisije, uloge))))
                .and(isIn(qDiplomskiRad.status, statuses))
                .and(isLike(qDiplomskiRad.studentIdFk.ime, diplomskiRadSearchDTO.getImeStudenta()))
                .and(isLike(qDiplomskiRad.studentIdFk.prezime, diplomskiRadSearchDTO.getPrezimeStudenta()))
                .and(isLike(qDiplomskiRad.studentIdFk.brojIndeksa, diplomskiRadSearchDTO.getBrojIndeksa()));
        List<DiplomskiRad> diplomskiRads = new ArrayList<>();
        diplomskiRadRepository.findAll(exp).forEach(diplomskiRads::add);
        List<AbstractDTO> diplomskiRadDTOs = new ArrayList<>();
        diplomskiRads.forEach((diplomskiRad) -> {
            diplomskiRadDTOs.add(mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRad));
        });
        return diplomskiRadDTOs;
    }

    BooleanExpression isLike(StringPath property, String searchProperty) {
        return searchProperty != null ? property.contains(searchProperty) : Expressions.asBoolean(true).isTrue();
    }

    private BooleanExpression isEq(StringPath property, String searchProperty) {
        return searchProperty != null ? property.eq(searchProperty) : Expressions.asBoolean(true).isTrue();
    }

    private BooleanExpression isIn(StringPath property, String[] searchProperty) {
        if (searchProperty.length == 0) {
            return Expressions.asBoolean(true).isTrue();
        }
        return property.in(searchProperty);
    }

    private BooleanExpression isIn(EnumPath property, List searchProperty) {
        if (searchProperty == null || searchProperty.isEmpty()) {
            return Expressions.asBoolean(true).isTrue();
        }

        return property.in(searchProperty);
    }

    private BooleanExpression isInGodineStudija(NumberPath property, Integer[] searchProperty) {
        return property.in(searchProperty);
    }

    public DiplomskiRadDTO getDiplomskiRad(String id) {
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.findById(Long.parseLong(id)).get());
    }

    DiplomskiRadDTO promeniClanaKomisije(ClanKaKlijentuDTO clanDTO,String diplomskiRadId) throws Exception {
        DiplomskiRad diplomskiRad = diplomskiRadRepository.findById(Long.parseLong(diplomskiRadId)).get();
        //validateKomisija(diplomskiRadUnesiKomisijuDTO, diplomskiRad);

        if (diplomskiRad.getStatus() != EnumStatus.ODREDJENA_KOMISIJA && diplomskiRad.getStatus() != EnumStatus.PREDAT) {
            throw new Exception("Ne moze se menjati komisija za rad za koji nije odredjena komisija!");
        }
        Nastavnik nastavnik;
        try {
                nastavnik = nastavnikRepository.findById(clanDTO.getNastavnikIdFk().getClanSistemaId()).get();

            } catch (Exception e) {
                throw new Exception("Nastavnik sa datim ID-jem: " + clanDTO.getNastavnikIdFk() + " ne postoji u bazi!");
            }
            if (!Arrays.asList(EnumTitula.DOCENT, EnumTitula.REDOVNI_PROFESOR, EnumTitula.VANREDNI_PROFESOR).contains(nastavnik.getTitula())) {
                throw new Exception("Nastavnik koji je u komisiji mora imati titulu docenta, vanrednog ili redovnog profesora");
            }
        for (ClanKomisije clanKomisije : diplomskiRad.getKomisijaIdFk().getClanKomisijeCollection()) {
            if(clanKomisije.getClanKomisijePK().getClanKomisijeRb() == clanDTO.getClanKomisijeRb()){
                clanKomisije.setNastavnikIdFk(nastavnik);
            }else{
                if(Objects.equals(clanKomisije.getNastavnikIdFk().getClanSistemaId(), clanDTO.getNastavnikIdFk().getClanSistemaId())){
                    throw new Exception("Ne smeju biti dva člana sa istim nastavnicima");
                }
            }
        }
        boolean saDrugeKatedre = false;
        Katedra katedra = diplomskiRad.getTemaIdFk().getPredmetIdFk().getKatedraIdFk();
        
        for (ClanKomisije clanKomisije : diplomskiRad.getKomisijaIdFk().getClanKomisijeCollection()) {
            if (clanKomisije.getUlogaClanaKomisije() == EnumUlogaClanaKomisije.MENTOR) {
                if (!clanKomisije.getNastavnikIdFk().getKatedraIdFk().equals(katedra)) {
                    throw new Exception("Mentor mora biti sa katedre ciji je i predmet");
                }
            } else if (!nastavnik.getKatedraIdFk().equals(katedra)) {
                saDrugeKatedre = true;
            }
        }
        
        if (!saDrugeKatedre) {
            throw new Exception("U komisiji mora biti barem jedan nastavnik koji nije sa katedre na kojoj je radjen diplomski rad!");
        }
       
        return mapper.diplomskiRadToDiplomskiRadDTO(diplomskiRadRepository.save(diplomskiRad));
    }

    @Override
    public AbstractDTO add(AbstractDTO dto, String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractDTO update(AbstractDTO dto, String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AbstractDTO delete(String[] ids) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
