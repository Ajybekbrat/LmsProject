package LmsProject.service.serviceImpl;

import LmsProject.dto.request.StudentDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Student;
import LmsProject.repository.StudentRepo;
import LmsProject.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public SimpleResponse save(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setStudyFormat(studentDto.getStudyFormat());
        studentRepo.save(student);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully saved")
                .build();
    }

    @Override
    public SimpleResponse delete(Long studentId) {
        studentRepo.deleteById(studentId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully deleted")
                .build();
    }
    @Override
    public SimpleResponse updateStudent(Long studentId, Student newStudent) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new EntityNotFoundException("student with id " + studentId + " not found!")
        );
student.setFirstName(newStudent.getFirstName());
student.setLastName(newStudent.getLastName());
student.setEmail(newStudent.getEmail());
student.setPhoneNumber(newStudent.getPhoneNumber());
student.setStudyFormat(newStudent.getStudyFormat());
studentRepo.save(student);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully updated")
                .build();
    }

    @Override
    public StudentDto findById(Long studentId) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new EntityNotFoundException("student with id " + studentId + " not found!")
        );
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setStudyFormat(student.getStudyFormat());
        return studentDto;
    }
}
