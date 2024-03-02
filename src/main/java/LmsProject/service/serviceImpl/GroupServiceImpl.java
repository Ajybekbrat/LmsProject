package LmsProject.service.serviceImpl;

import LmsProject.dto.request.SaveGroupDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Course;
import LmsProject.entities.Group;
import LmsProject.repository.CourseRepo;
import LmsProject.repository.GroupRepo;
import LmsProject.service.GroupService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepo groupRepo;
    private final CourseRepo courseRepo;
    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public SimpleResponse save(Long courseId, SaveGroupDto saveGroupApi) {
       Course course = courseRepo.findById(courseId).orElseThrow(
                () -> new EntityNotFoundException("course with id " + courseId + " not found!")
        );
       Group group = new Group();
       course.getGroups().add(group);
       List<Course>courses = new ArrayList<>();
       courses.add(course);
       group.setCourses(courses);
       group.setGroupName(saveGroupApi.getGroupName());
       group.setDescriptions(saveGroupApi.getDescriptions());
       group.setImageLink(saveGroupApi.getImageLink());
       groupRepo.save(group);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully saved")
                .build();
    }

    @Override
    public SaveGroupDto findById(Long groupId) {
        Group group = groupRepo.findById(groupId).orElseThrow(
                () -> new EntityNotFoundException("group with id " + groupId + " not found!")
        );
SaveGroupDto saveGroupApi = new SaveGroupDto();
saveGroupApi.setGroupName(group.getGroupName());
saveGroupApi.setDescriptions(group.getDescriptions());
saveGroupApi.setImageLink(group.getImageLink());
        return saveGroupApi;
    }

    @Override
    public SimpleResponse updateGroup(Long groupId, Group newGroup) {
        Group group = groupRepo.findById(groupId).orElseThrow(
                () -> new EntityNotFoundException("groupId with id " + groupId + " not found!")
        );


        group.setGroupName(newGroup.getGroupName());
        group.setDescriptions(newGroup.getDescriptions());
        group.setImageLink(newGroup.getImageLink());

        groupRepo.save(group);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully updated")
                .build();

    }

    @Override
    public SimpleResponse delete(Long groupId) {
        groupRepo.deleteById(groupId);
        return  SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully deleted")
                .build();

    }
}
