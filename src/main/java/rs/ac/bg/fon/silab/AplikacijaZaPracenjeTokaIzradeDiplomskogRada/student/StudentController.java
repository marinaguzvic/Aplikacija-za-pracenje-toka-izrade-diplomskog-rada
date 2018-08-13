/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.StudentDTO;
import rs.ac.bg.fon.silab.AplikacijaZaPracenjeTokaIzradeDiplomskogRada.dto.StudentSearchDTO;

/**
 *
 * @author Marina Guzvic
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }
    
        @RequestMapping(method = RequestMethod.POST, value = "/students/search")
    public List<StudentDTO> addStudent(@RequestBody StudentSearchDTO student) {
        return studentService.searchStudents(student);
    }

    @RequestMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students/{id}")
    public StudentDTO addStudent(@RequestBody StudentDTO student,@PathVariable String id) {
        return studentService.addStudent(student,id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public StudentDTO updateStudent(@RequestBody StudentDTO student) {
        return studentService.updateStudent(student);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        
        studentService.deleteStudent(id);
    }
}
