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
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.diplomskiraddtos.ClanDTO;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class ClanKomisijeService {

    @Autowired
    ClanKomisijeRepository clanKomisijeRepository;
    @Autowired
    GenericMapper mapper;

    List<ClanDTO> getAllClanKomisijes(String komisijaId) {
        List<ClanKomisije> clanKomisijes = new ArrayList<>();
        clanKomisijeRepository.findByClanKomisijePKKomisijaIdFk(Long.parseLong(komisijaId)).forEach(clanKomisijes::add);
        List<ClanDTO> clans = new ArrayList<>();
        for (ClanKomisije clanKomisije : clanKomisijes) {
            clans.add(mapper.clanKomisijeToClanDTO(clanKomisije));
        }
        return clans;
    }

    ClanDTO getClanKomisije(String komisijaId, String clanRb) {
        return mapper.clanKomisijeToClanDTO(clanKomisijeRepository.findById(new ClanKomisijePK(Long.parseLong(komisijaId), Integer.parseInt(clanRb))).get());
    }

    ClanDTO addClanKomisije(ClanDTO clanDTO, String komisijaId,String clanKomisijeRb) {
        ClanKomisije clanKomisije = mapper.clanDTOToClanKomisije(clanDTO);
        clanKomisije.setClanKomisijePK(new ClanKomisijePK(Long.parseLong(komisijaId), Integer.parseInt(clanKomisijeRb)));
        clanKomisijeRepository.save(clanKomisije);
        return clanDTO;
    }

    ClanDTO updateClanKomisije(ClanDTO clanDTO, String komisijaId,String clanKomisijeRb) {
        ClanKomisije clanKomisije = mapper.clanDTOToClanKomisije(clanDTO);
        clanKomisije.setClanKomisijePK(new ClanKomisijePK(Long.parseLong(komisijaId), Integer.parseInt(clanKomisijeRb)));
        clanKomisijeRepository.save(clanKomisije);
        return clanDTO;
    }

    void deleteClanKomisije(String komisijaId, String clanRb) {
        clanKomisijeRepository.deleteById(new ClanKomisijePK(Long.parseLong(komisijaId), Integer.parseInt(clanRb)));
    }

}
