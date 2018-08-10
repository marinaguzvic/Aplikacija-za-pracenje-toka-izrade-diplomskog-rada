/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clankomisije;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisije;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.ClanKomisijePK;

/**
 *
 * @author Marina Guzvic
 */
public interface ClanKomisijeRepository extends CrudRepository<ClanKomisije, ClanKomisijePK>{
    public List<ClanKomisije> findByClanKomisijePKKomisijaIdFk(Long komisijaIdFk);
}
