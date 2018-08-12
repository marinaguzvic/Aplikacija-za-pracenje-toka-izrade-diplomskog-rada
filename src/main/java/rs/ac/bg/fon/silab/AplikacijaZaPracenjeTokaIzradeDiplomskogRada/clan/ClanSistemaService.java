/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clan;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanSistema;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class ClanSistemaService {
    
    @Autowired
    ClanSistemaRepository clanSistemaRepository;

    public List<ClanSistema> getAllClanSistemas() {
        List<ClanSistema> clanSistemas = new ArrayList<>();
        clanSistemaRepository.findAll().forEach(clanSistemas::add);
        return  clanSistemas;
    }

    public ClanSistema getClanSistema(String id) {
        return clanSistemaRepository.findById(Long.parseLong(id)).get();
    }

    public void addTemaDiplomskogRada(ClanSistema clanSistema) {
        
        clanSistemaRepository.save(clanSistema);
    }

    public void updateClanSistema(ClanSistema clanSistema) {
        clanSistemaRepository.save(clanSistema);
    }

    public void deleteClanSistema(String id) {
        clanSistemaRepository.deleteById(Long.parseLong(id));
    }
    
}
