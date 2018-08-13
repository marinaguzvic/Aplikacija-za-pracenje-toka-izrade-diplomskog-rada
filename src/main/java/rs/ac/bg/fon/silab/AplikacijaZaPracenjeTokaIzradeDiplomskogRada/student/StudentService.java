/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.student;


import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.lang.reflect.Array;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.temaDiplomskogRada.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Query;
import org.eclipse.persistence.jpa.JpaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clan.ClanSistemaRepository;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.StudentDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.StudentSearchDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.QStudent;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GenericMapper mapper;

    public List<StudentDTO> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student student : students) {
            studentDTOs.add(mapper.studentToStudentDTO(student));
        }
        return studentDTOs;
    }

    public StudentDTO getStudent(String id) {
        return mapper.studentToStudentDTO(studentRepository.findById(Long.parseLong(id)).get());
    }

    StudentDTO addStudent(StudentDTO student, String id) {

        return mapper.studentToStudentDTO(studentRepository.save(mapper.studentDTOToStudent(student)));
    }

    StudentDTO updateStudent(StudentDTO student) {
        return mapper.studentToStudentDTO(studentRepository.save(mapper.studentDTOToStudent(student)));
    }

    void deleteStudent(String id) {
        studentRepository.deleteById(Long.parseLong(id));
    }

    List<StudentDTO> searchStudents(StudentSearchDTO student) {
        QStudent qStudent = QStudent.student;
        Predicate predicate = isLike(qStudent.ime, student.getIme())
                .and(isLike(qStudent.prezime, student.getPrezime()))
                .and(isLike(qStudent.jmbg, student.getJmbg()))
                .and(isLike(qStudent.brojTelefona, student.getBrojTelefona()))
                .and(isLike(qStudent.brojIndeksa, student.getBrojIndeksa()))
                .and(isEq(qStudent.datumRodjenja, student.getDatumRodjenja()))
                .and(isInGodineStudija(qStudent.godinaStudija, student.getGodineStudija()));
        List<Student> studennts = new ArrayList<>();
        studentRepository.findAll(predicate).forEach(studennts::add);
        List<StudentDTO> studentDTOs = new ArrayList<>();
        studennts.forEach((studennt) -> {
            studentDTOs.add(mapper.studentToStudentDTO(studennt));
        });
        return studentDTOs;
    }

    BooleanExpression isLike(StringPath property, String searchProperty) {
        return searchProperty != null ? property.contains(searchProperty) : Expressions.asBoolean(true).isTrue();
    }

    private BooleanExpression isEq(DatePath property, Date searchProperty) {
        return searchProperty != null ? property.eq(searchProperty) : Expressions.asBoolean(true).isTrue();
    }
    
    private BooleanExpression isInGodineStudija(NumberPath property, Integer[] searchProperty) {
        return property.in(searchProperty);
    }
}
