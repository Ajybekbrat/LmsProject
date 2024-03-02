package LmsProject.service;

import LmsProject.dto.request.SaveGroupDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();

    SimpleResponse save(Long companyId, SaveGroupDto saveGroupApi);

    SaveGroupDto findById(Long groupId);

    SimpleResponse updateGroup(Long groupId, Group newGroup);

    SimpleResponse delete(Long groupId);
}
