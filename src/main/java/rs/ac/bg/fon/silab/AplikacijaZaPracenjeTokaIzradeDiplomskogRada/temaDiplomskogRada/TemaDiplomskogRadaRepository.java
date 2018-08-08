/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.temaDiplomskogRada;

import java.util.List;
import javax.validation.constraints.AssertFalse;
import org.springframework.data.repository.CrudRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;

/**
 *
 * @author Marina Guzvic
 */
public interface TemaDiplomskogRadaRepository extends CrudRepository<TemaDiplomskogRada, Long>{
    public List<TemaDiplomskogRada> getTemaDiplomskogRadasByNazivTeme(String nazivTeme);
}
