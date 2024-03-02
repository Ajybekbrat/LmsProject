package LmsProject.api;

import LmsProject.dto.request.SaveGroupDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Group;
import LmsProject.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupApi {
    @Autowired
    private  GroupService groupService;
    @GetMapping("/all")
    public List<Group> findAll() {
        return groupService.findAll();
    }

    @PostMapping("/new/{courseId}")
    public SimpleResponse saveGroup(@RequestBody SaveGroupDto saveGroupApi, @PathVariable Long courseId) {
        return groupService.save(courseId, saveGroupApi);
    }
    @GetMapping("/delete/{groupId}")
    public SimpleResponse deleteGroup(@PathVariable Long groupId){
        return groupService.delete(groupId);
    }
    @PutMapping("/update/{groupId}")
    public SimpleResponse updateGroup(@RequestBody Group newGroup, @PathVariable Long groupId){
        return groupService.updateGroup(groupId, newGroup);
    }
    @GetMapping("/find/{groupId}")
    public SaveGroupDto findById(@PathVariable Long groupId){
        return groupService.findById(groupId);
    }
}
