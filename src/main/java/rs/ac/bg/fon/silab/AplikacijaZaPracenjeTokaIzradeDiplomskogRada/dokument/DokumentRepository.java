/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dokument;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Dokument;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DokumentPK;

/**
 *
 * @author Marina Guzvic
 */
public interface DokumentRepository extends CrudRepository<Dokument, DokumentPK>{
    public List<Dokument> findByDokumentPKDiplomskiRadIdFk(Long diplomskiRadIdFk);
}
