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
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentDTO;
import rs.ac.bg.fon.silab.diplomskiraddtos.StudentSearchDTO;

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
    public List<StudentDTO> searchStudent(@RequestBody StudentSearchDTO student) throws Exception {
        return studentService.searchStudents(student);
    }

    @RequestMapping("/students/{id}")
    public StudentDTO getStudent(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public StudentDTO addStudent(@RequestBody StudentDTO student) throws Exception {
        return studentService.addStudent(student);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public StudentDTO updateStudent(@RequestBody StudentDTO student,@PathVariable String id) throws Exception {
        student.setClanSistemaId(Long.parseLong(id));
        return studentService.updateStudent(student);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/students/{id}")
    public void deleteStudent(@PathVariable String id) throws Exception {
        
        studentService.deleteStudent(id);
    }
}
