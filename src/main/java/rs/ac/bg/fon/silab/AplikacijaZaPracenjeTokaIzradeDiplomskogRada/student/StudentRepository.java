/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.student;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
/**
 *
 * @author Marina Guzvic
 */
public interface StudentRepository extends CrudRepository<Student, Long>,QuerydslPredicateExecutor<Student>{
    @Query(value = "select s from Student s where brojIndeksa like ?1% order by brojIndeksa desc")
    List<Student> findByBrojIndeksaStartingWith(String godina);
    Student findByJmbg(String jmbg);
}
