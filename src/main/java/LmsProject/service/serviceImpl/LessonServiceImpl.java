package LmsProject.service.serviceImpl;

import LmsProject.dto.request.LessonDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Course;
import LmsProject.entities.Lesson;
import LmsProject.repository.CourseRepo;
import LmsProject.repository.LessonRepo;
import LmsProject.service.LessonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepo lessonRepo;
    private final CourseRepo courseRepo;
    @Override
    public SimpleResponse save(Long courseId, LessonDto lessonDto) {
        Course course = courseRepo.findById(courseId).orElseThrow(
                () -> new EntityNotFoundException("course with id " + courseId + " not found!")
        );

        Lesson lesson = new Lesson();
        lesson.setCourse(course);
        lesson.setLessonName(lessonDto.getLessonName());
        lessonRepo.save(lesson);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully saved")
                .build();
    }

    @Override
    public SimpleResponse delete(Long lessonId) {
        lessonRepo.deleteById(lessonId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully deleted")
                .build();
    }

    @Override
    public SimpleResponse updateLesson(Long lessonId, Lesson newLesson) {
        Lesson lesson = lessonRepo.findById(lessonId).orElseThrow(
                () -> new EntityNotFoundException("lesson with id " + lessonId + " not found!")
        );
lesson.setLessonName(newLesson.getLessonName());
lessonRepo.save(lesson);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully updated")
                .build();
    }

    @Override
    public LessonDto findById(Long lessonId) {
        LessonDto lessonDto = new LessonDto();
        Lesson lesson = lessonRepo.findById(lessonId).orElseThrow(
                () -> new EntityNotFoundException("lesson with id " + lessonId + " not found!")
        );
        lessonDto.setLessonName(lesson.getLessonName());
        return lessonDto;
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepo.findAll();
    }
}
