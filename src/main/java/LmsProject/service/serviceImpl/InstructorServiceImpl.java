package LmsProject.service.serviceImpl;

import LmsProject.dto.request.SaveInstructorDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Company;
import LmsProject.entities.Course;
import LmsProject.entities.Instructor;
import LmsProject.repository.CompanyRepo;
import LmsProject.repository.CourseRepo;
import LmsProject.repository.InstructorRepo;
import LmsProject.service.InstructorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepo instructorRepo;
    private final CompanyRepo companyRepo;
    private final CourseRepo courseRepo;
    @Override
    public List<Instructor> findAll() {
        return instructorRepo.findAll();
    }

    @Override
    public SimpleResponse save(SaveInstructorDto saveInstructorDto) {
        Instructor instructor = new Instructor();
        instructor.setFirstName(saveInstructorDto.getFirstName());
        instructor.setLastName(saveInstructorDto.getLastName());
        instructor.setPhoneNumber(saveInstructorDto.getPhoneNumber());
        instructor.setSpecialization(saveInstructorDto.getSpecialization());
        instructorRepo.save(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully saved")
                .build();
    }

    @Override
    public SimpleResponse delete(Long instructorId) {
        instructorRepo.deleteById(instructorId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully deleted")
                .build();
    }

    @Override
    public SimpleResponse updateIstructor(Long instructorId, Instructor newInstructor) {
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow(
                () -> new EntityNotFoundException("instructor with id " + instructorId + " not found!")
        );
instructor.setFirstName(newInstructor.getFirstName());
instructor.setLastName(newInstructor.getLastName());
instructor.setPhoneNumber(newInstructor.getPhoneNumber());
instructor.setSpecialization(newInstructor.getSpecialization());
instructorRepo.save(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully updated")
                .build();
    }

    @Override
    public SaveInstructorDto findById(Long instructorId) {
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow(
                () -> new EntityNotFoundException("instructor with id " + instructorId + " not found!")
        );
        SaveInstructorDto saveInstructorDto = new SaveInstructorDto();
        saveInstructorDto.setFirstName(instructor.getFirstName());
        saveInstructorDto.setLastName(instructor.getLastName());
        saveInstructorDto.setPhoneNumber(instructor.getLastName());
        saveInstructorDto.setSpecialization(instructor.getSpecialization());

        return saveInstructorDto;
    }

    @Override @Transactional
    public SimpleResponse assingInstructorToCompany(Long instructorId, Long companyId) {
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow(
                () -> new EntityNotFoundException("instructor with id " + instructorId + " not found!")
        );
        Company company = companyRepo.findById(companyId).orElseThrow(
                () -> new EntityNotFoundException("company with id " + companyId + " not found!")
        );
        instructor.getCompanies().add(company);
        company.getInstructors().add(instructor);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully assined")
                .build();
    }

    @Override @Transactional
    public SimpleResponse assingInstructorToCourse(Long instructorId, Long courseId) {
        Instructor instructor = instructorRepo.findById(instructorId).orElseThrow(
                () -> new EntityNotFoundException("instructor with id " + instructorId + " not found!")
        );
        Course course = courseRepo.findById(courseId).orElseThrow(
                () -> new EntityNotFoundException("course with id " + courseId + " not found!")
        );
        course.setInstructor(instructor);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully assined")
                .build();
    }
}
