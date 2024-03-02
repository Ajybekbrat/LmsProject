package LmsProject.api;

import LmsProject.dto.request.StudentDto;
import LmsProject.dto.request.TaskDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Student;
import LmsProject.entities.Task;
import LmsProject.service.StudentService;
import LmsProject.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/task")
public class TaskApi {
    @Autowired
    private TaskService taskService;
    @GetMapping("/all")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping("/new/{lessonId}")
    public SimpleResponse saveTask(@RequestBody TaskDto taskDto, @PathVariable Long lessonId) {
        return taskService.save(lessonId,taskDto);
    }
    @GetMapping("/delete/{taskId}")
    public SimpleResponse deleteTask(@PathVariable Long taskId){
        return taskService.delete(taskId);
    }
    @PutMapping("/update/{taskId}")
    public SimpleResponse updateTask(@RequestBody Task newTask, @PathVariable Long taskId){
        return taskService.updateTask(taskId, newTask);
    }
    @GetMapping("/find/{taskId}")
    public TaskDto findById(@PathVariable Long taskId){
        return taskService.findById(taskId);
    }

}
