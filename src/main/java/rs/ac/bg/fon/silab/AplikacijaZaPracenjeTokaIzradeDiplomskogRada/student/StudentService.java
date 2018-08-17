/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.student;


import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.Student;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.entity.QStudent;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.mapper.GenericMapper;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentSearchDTO;

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

    StudentDTO addStudent(StudentDTO student) throws Exception {
        validateStudent(student);
        setBrojIndeksa(student);
        validateStudentUniqueFields(student);
        return mapper.studentToStudentDTO(studentRepository.save(mapper.studentDTOToStudent(student)));
    }

    StudentDTO updateStudent(StudentDTO student) {
        return mapper.studentToStudentDTO(studentRepository.save(mapper.studentDTOToStudent(student)));
    }

    void deleteStudent(String id) throws Exception {
        Student student;
        try {
            student = studentRepository.findById(Long.parseLong(id)).get();
        } catch (Exception e) {
            throw new Exception("Student se ne moze obrisati jer ne postoji u bazi");
            
        }
        if(student.getDiplomskiRadCollection() != null)throw new Exception("Studnet se ne moze obrisati jer ima prijavljen diplomski rad.");
        studentRepository.deleteById(Long.parseLong(id));
    }

    List<StudentDTO> searchStudents(StudentSearchDTO student) throws Exception {
        try {
            QStudent qStudent = QStudent.student;
            Predicate predicate = isLike(qStudent.ime, student.getIme())
                    .and(isLike(qStudent.prezime, student.getPrezime()))
                    .and(isLike(qStudent.jmbg, student.getJmbg()))
                    .and(isLike(qStudent.brojTelefona, student.getBrojTelefona()))
                    .and(isLike(qStudent.brojIndeksa, student.getBrojIndeksa()))
                    .and(isEq(qStudent.datumRodjenja, new SimpleDateFormat().parse(student.getDatumRodjenja())))
                    .and(isInGodineStudija(qStudent.godinaStudija, student.getGodineStudija()));
            List<Student> studennts = new ArrayList<>();
            studentRepository.findAll(predicate).forEach(studennts::add);
            List<StudentDTO> studentDTOs = new ArrayList<>();
            studennts.forEach((studennt) -> {
                studentDTOs.add(mapper.studentToStudentDTO(studennt));
            });
            return studentDTOs;
        } catch (ParseException ex) {
            throw new Exception("Greska kod parsiranja datuma");
        }
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

    private void validateStudent(StudentDTO student) throws Exception {
        
        try {
            Long.parseLong(student.getJmbg());
        } catch (NumberFormatException pe) {
            throw new Exception("U polju jmbg postoje karakteri koji nisu cifre!");
        }
        try {
            Long.parseLong(student.getBrojTelefona());
        } catch (NumberFormatException pe) {
            throw new Exception("U polju broj telefona postoje karakteri koji nisu cifre!");
        }
        if (student.getBrojTelefona().length() < 9 || student.getBrojTelefona().length() > 14) {
            throw new Exception("Uneti broj telefona nije ispravan po broju cifara.");
        }
        if (student.getJmbg().length() != 13) {
            throw new Exception("JMBG mora da ima 13 cifara, uneto je: " + student.getJmbg().length());
        }
        if (student.getIme().length() <= 2) {
            throw new Exception("Ime sadrži manje od 3 karaktera!");
        }
        for (char c : student.getIme().toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new Exception("Karakter " + c + " u imenu nije slovo!");
            }
        }
        if (student.getPrezime().length() <= 2) {
            throw new Exception("Prezime sadrži manje od 3 karaktera!");
        }
        for (char c : student.getPrezime().toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new Exception("Karakter " + c + " u prezimenu nije slovo!");
            }
        }
    }

    private void setBrojIndeksa(StudentDTO student) {
        String indexNo;
        List<Student> students =  studentRepository.findByBrojIndeksaStartingWith(String.valueOf(LocalDate.now().get(ChronoField.YEAR_OF_ERA)));
        if(student == null || students.isEmpty())indexNo = String.valueOf(LocalDate.now().get(ChronoField.YEAR_OF_ERA)) + "0001";
        else{
            String lastIndexNo = students.get(0).getBrojIndeksa().substring(4);
            Integer noInt = Integer.parseInt(lastIndexNo);
            noInt++;
            String formattedNo = String.format("%04d", noInt);
            indexNo = String.valueOf(LocalDate.now().get(ChronoField.YEAR_OF_ERA)) + formattedNo;
            
        }
        student.setBrojIndeksa(indexNo);
    }

    private void validateStudentUniqueFields(StudentDTO student) throws Exception {
        if(studentRepository.findByJmbg(student.getJmbg()) != null) throw new Exception("Jmbg mora biti jedinstven!");
    }
}
