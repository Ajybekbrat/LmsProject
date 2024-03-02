package LmsProject.api;

import LmsProject.dto.request.SaveCompanyDto;
import LmsProject.dto.request.SaveCourseDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Course;
import LmsProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class courseApi {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @PostMapping("/new/{companyId}")
    public SimpleResponse saveCourse(@RequestBody SaveCourseDto saveCourseDto, @PathVariable Long companyId) {
        return courseService.save(companyId, saveCourseDto);
    }
    @GetMapping("/delete/{courseId}")
    public SimpleResponse deleteCompany(@PathVariable Long courseId){
        return courseService.delete(courseId);
    }
    @PutMapping("/update/{courseId}")
    public SimpleResponse updateCourse(@RequestBody Course newCourse, @PathVariable Long courseId){
        return courseService.updateCourse(courseId, newCourse);
    }
    @GetMapping("/find/{courseId}")
    public SaveCourseDto findById(@PathVariable Long courseId){
        return courseService.findById(courseId);
    }
}


