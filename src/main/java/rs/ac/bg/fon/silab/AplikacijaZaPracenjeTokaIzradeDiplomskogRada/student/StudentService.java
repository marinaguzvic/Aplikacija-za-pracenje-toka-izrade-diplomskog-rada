/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.student;

import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.temaDiplomskogRada.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.TemaDiplomskogRada;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.clan.ClanSistemaRepository;

/**
 *
 * @author Marina Guzvic
 */
@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student getStudent(String id) {
        return studentRepository.findById(Long.parseLong(id)).get();
    }

    void addStudent(Student student,String id) {
        
        studentRepository.save(student);
    }

    void updateStudent(Student student) {
        studentRepository.save(student);
    }

    void deleteStudent(String id) {
        studentRepository.deleteById(Long.parseLong(id));
    }
    
}
