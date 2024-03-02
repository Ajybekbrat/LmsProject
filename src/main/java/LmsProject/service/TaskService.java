package LmsProject.service;

import LmsProject.dto.request.TaskDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    SimpleResponse delete(Long taskId);

    SimpleResponse updateTask(Long taskId, Task newTask);

    TaskDto findById(Long taskId);

    SimpleResponse save(Long lessonId,TaskDto taskDto);
}
