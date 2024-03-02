package LmsProject.service;

import LmsProject.dto.request.StudentDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    SimpleResponse save(StudentDto studentDto);

    SimpleResponse delete(Long studentId);

    SimpleResponse updateStudent(Long studentId, Student newStudent);

    StudentDto findById(Long studentId);
}
