package LmsProject.service;

import LmsProject.dto.request.LessonDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Lesson;

import java.util.List;

public interface LessonService {
    SimpleResponse save(Long courseId, LessonDto lessonDto);

    SimpleResponse delete(Long lessonId);

    SimpleResponse updateLesson(Long lessonId, Lesson newLesson);

    LessonDto findById(Long lessonId);

    List<Lesson> findAll();
}
