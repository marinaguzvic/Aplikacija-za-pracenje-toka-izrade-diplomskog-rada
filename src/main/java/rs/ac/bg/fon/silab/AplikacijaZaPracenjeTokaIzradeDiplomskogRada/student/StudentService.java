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
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.StudentDTO;
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

    StudentDTO addStudent(StudentDTO student,String id) {
        
        return mapper.studentToStudentDTO(studentRepository.save(mapper.studentDTOToStudent(student)));
    }

    StudentDTO updateStudent(StudentDTO student) {
        return mapper.studentToStudentDTO(studentRepository.save(mapper.studentDTOToStudent(student)));
    }

    void deleteStudent(String id) {
        studentRepository.deleteById(Long.parseLong(id));
    }
    
}
