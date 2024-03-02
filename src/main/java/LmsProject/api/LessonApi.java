package LmsProject.api;

import LmsProject.dto.request.LessonDto;
import LmsProject.dto.request.SaveInstructorDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Instructor;
import LmsProject.entities.Lesson;
import LmsProject.service.InstructorService;
import LmsProject.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/lesson")
public class LessonApi {
    @Autowired
    private LessonService lessonService;
    @GetMapping("/all")
    public List<Lesson> findAll() {
        return lessonService.findAll();
    }

    @PostMapping("/new/{courseId}")
    public SimpleResponse saveLesson(@RequestBody LessonDto lessonDto, @PathVariable Long courseId) {
        return lessonService.save(courseId,lessonDto);
    }
    @GetMapping("/delete/{lessonId}")
    public SimpleResponse deleteLesson(@PathVariable Long lessonId){
        return lessonService.delete(lessonId);
    }
    @PutMapping("/update/{lessonId}")
    public SimpleResponse updateLesson(@RequestBody Lesson newLesson, @PathVariable Long lessonId){
        return lessonService.updateLesson(lessonId, newLesson);
    }
    @GetMapping("/find/{lessonId}")
    public LessonDto findById(@PathVariable Long lessonId){
        return lessonService.findById(lessonId);
    }
}
