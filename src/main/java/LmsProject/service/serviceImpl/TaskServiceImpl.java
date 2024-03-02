package LmsProject.service.serviceImpl;

import LmsProject.dto.request.TaskDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Lesson;
import LmsProject.entities.Task;
import LmsProject.repository.LessonRepo;
import LmsProject.repository.TaskRepo;
import LmsProject.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepo taskRepo;
    private final LessonRepo lessonRepo;
    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    @Override
    public SimpleResponse delete(Long taskId) {
        taskRepo.deleteById(taskId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully deleted")
                .build();
    }

    @Override
    public SimpleResponse updateTask(Long taskId, Task newTask) {
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new EntityNotFoundException("task with id " + taskId + " not found!")
        );
        task.setTaskName(newTask.getTaskName());
        task.setTaskTex(newTask.getTaskTex());
        task.setDeadLine(newTask.getDeadLine());
 ;       taskRepo.save(task);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully updated")
                .build();
    }

    @Override
    public TaskDto findById(Long taskId) {
        TaskDto taskDto = new TaskDto();
        Task task = taskRepo.findById(taskId).orElseThrow(() -> new EntityNotFoundException("task with id " + taskId + " not found!")
        );
        taskDto.setTaskName(task.getTaskName());
        taskDto.setTaskTex(task.getTaskTex());
        taskDto.setDeadLine(task.getDeadLine());
        return taskDto;
    }

    @Override
    public SimpleResponse save(Long lessonId, TaskDto taskDto) {
        Lesson lesson = lessonRepo.findById(lessonId).orElseThrow(
                () -> new EntityNotFoundException("lesson with id " + lessonId + " not found!")
        );
        Task task = new Task();
        task.setLesson(lesson);
        task.setTaskName(taskDto.getTaskName());
        task.setTaskTex(taskDto.getTaskTex());
        task.setDeadLine(taskDto.getDeadLine());
        taskRepo.save(task);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully saved")
                .build() ;
    }
}
