/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clankomisije;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisijePK;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Nalog;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class ClanKomisijeService {

    @Autowired
    ClanKomisijeRepository clanKomisijeRepository;

    List<ClanKomisije> getAllClanKomisijes(String komisijaId) {
        List<ClanKomisije> clanKomisijes = new ArrayList<>();
        clanKomisijeRepository.findByClanKomisijePKKomisijaIdFk(Long.parseLong(komisijaId)).forEach(clanKomisijes::add);
        return clanKomisijes;
    }

    ClanKomisije getClanKomisije(String komisijaId, String clanRb) {
        return clanKomisijeRepository.findById(new ClanKomisijePK(Long.parseLong(komisijaId), Integer.parseInt(clanRb))).get();
    }

    void addClanKomisije(ClanKomisije clanKomisije, String komisijaId) {
        clanKomisije.getClanKomisijePK().setKomisijaIdFk(Long.parseLong(komisijaId));
        clanKomisijeRepository.save(clanKomisije);
    }

    void updateClanKomisije(ClanKomisije clanKomisije, String komisijaId) {
        clanKomisije.getClanKomisijePK().setKomisijaIdFk(Long.parseLong(komisijaId));
        clanKomisijeRepository.save(clanKomisije);
    }

    void deleteClanKomisije(String komisijaId, String clanRb) {
        clanKomisijeRepository.deleteById(new ClanKomisijePK(Long.parseLong(komisijaId), Integer.parseInt(clanRb)));
    }

}
