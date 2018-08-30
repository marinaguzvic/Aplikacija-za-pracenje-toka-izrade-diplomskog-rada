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
import rs.ac.bg.fon.silab.diplomskiraddtos.AbstractDTO;
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
    public List<AbstractDTO> getAllStudents() {
        return studentService.getAll(new String[]{});
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/students/search")
    public List<AbstractDTO> searchStudent(@RequestBody StudentSearchDTO student) throws Exception {
        return studentService.search(student);
    }

    @RequestMapping("/students/{id}")
    public AbstractDTO getStudent(@PathVariable String id) {
        return studentService.get(new String[]{id});
    }

    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public AbstractDTO addStudent(@RequestBody StudentDTO student) throws Exception {
        return studentService.add(student,new String[]{});
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public AbstractDTO updateStudent(@RequestBody StudentDTO student,@PathVariable String id) throws Exception {
        student.setClanSistemaId(Long.parseLong(id));
        return studentService.update(student,new String[]{id});
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value = "/students/{id}")
    public AbstractDTO deleteStudent(@PathVariable String id) throws Exception {
        return studentService.delete(new String[]{id});
    }
}
