package LmsProject.service;

import LmsProject.dto.request.SaveInstructorDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAll();

    SimpleResponse save(SaveInstructorDto saveInstructorDto);

    SimpleResponse delete(Long instructorId);

    SimpleResponse updateIstructor(Long instructorId, Instructor newInstructor);

    SaveInstructorDto findById(Long instructorId);

    SimpleResponse assingInstructorToCompany(Long instructorId, Long companyId);

    SimpleResponse assingInstructorToCourse(Long instructorId, Long courseId);
}
