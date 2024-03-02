package LmsProject.service.serviceImpl;

import LmsProject.dto.request.SaveCourseDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Company;
import LmsProject.entities.Course;
import LmsProject.repository.CompanyRepo;
import LmsProject.repository.CourseRepo;
import LmsProject.service.CourseService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final CompanyRepo companyRepo;
    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public SimpleResponse save(Long id, SaveCourseDto saveCourseDto) {
        Company company = companyRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("company with id " + id + " not found!")
        );
        Course course= new Course();
        course.setCourseName(saveCourseDto.getCourseName());
        course.setDescription(saveCourseDto.getDescription());
        course.setDateOfStart(saveCourseDto.getDateOfStart());
       course.setCompany(company);
courseRepo.save(course);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully saved")
                .build();
    }

    @Override
    public SimpleResponse delete(Long courseId) {
        courseRepo.deleteById(courseId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully deleted")
                .build();
    }

    @Override
    public SimpleResponse updateCourse(Long courseId, Course newCourse) {
      Course course = courseRepo.findById(courseId).orElseThrow(
                () -> new EntityNotFoundException("course with id " + courseId + " not found!")
        );

        course.setCourseName(newCourse.getCourseName());
        course.setDescription(newCourse.getDescription());
        course.setDateOfStart(newCourse.getDateOfStart());

        courseRepo.save(course);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully updated")
                .build();

    }

    @Override
    public SaveCourseDto findById(Long id) {
      Course course=  courseRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("course with id " + id + " not found!")
        );
      SaveCourseDto saveCourseDto = new SaveCourseDto();
      saveCourseDto.setCourseName(course.getCourseName());
      saveCourseDto.setDescription(course.getDescription());
      saveCourseDto.setDateOfStart(course.getDateOfStart());
        return saveCourseDto;
    }


}
