package LmsProject.api;

import LmsProject.dto.request.LessonDto;
import LmsProject.dto.request.StudentDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Lesson;
import LmsProject.entities.Student;
import LmsProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/student")
public class StudentApi {
    @Autowired
    private StudentService studentService;
    @GetMapping("/all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/new")
    public SimpleResponse saveStudent(@RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);
    }
    @GetMapping("/delete/{studentId}")
    public SimpleResponse deleteStudent(@PathVariable Long studentId){
        return studentService.delete(studentId);
    }
    @PutMapping("/update/{studentId}")
    public SimpleResponse updateStudent(@RequestBody Student  newStudent, @PathVariable Long studentId){
        return studentService.updateStudent(studentId, newStudent);
    }
    @GetMapping("/find/{studentId}")
    public StudentDto findById(@PathVariable Long studentId){
        return studentService.findById(studentId);
    }

}
