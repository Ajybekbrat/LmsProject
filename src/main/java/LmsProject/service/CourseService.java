package LmsProject.service;

import LmsProject.dto.request.SaveCourseDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    SimpleResponse save(Long id,SaveCourseDto saveCourseDto);

    SimpleResponse delete(Long courseId);

    SimpleResponse updateCourse(Long courseId, Course newCourse);

    SaveCourseDto findById(Long id);
}
