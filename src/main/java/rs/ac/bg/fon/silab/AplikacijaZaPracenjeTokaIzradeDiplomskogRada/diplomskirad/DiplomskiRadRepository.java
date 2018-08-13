/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.diplomskirad;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.DiplomskiRad;

/**
 *
 * @author Marina Guzvic
 */
public interface DiplomskiRadRepository extends CrudRepository<DiplomskiRad, Long>,QuerydslPredicateExecutor<DiplomskiRad>{
    public DiplomskiRad findByStudentIdFkClanSistemaId(Long clanSistemaId);
    public DiplomskiRad findBytemaIdFkTemaId(Long temaId);
}
