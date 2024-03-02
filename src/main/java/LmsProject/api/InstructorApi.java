package LmsProject.api;

import LmsProject.dto.request.SaveGroupDto;
import LmsProject.dto.request.SaveInstructorDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Group;
import LmsProject.entities.Instructor;
import LmsProject.service.GroupService;
import LmsProject.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorApi {
    @Autowired
    private InstructorService instructorService;
    @GetMapping("/all")
    public List<Instructor> findAll() {
        return instructorService.findAll();
    }

    @PostMapping("/new")
    public SimpleResponse saveInstructor(@RequestBody SaveInstructorDto saveInstructorDto) {
        return instructorService.save(saveInstructorDto);
    }
    @GetMapping("/delete/{instructorId}")
    public SimpleResponse deleteInstructor(@PathVariable Long instructorId){
        return instructorService.delete(instructorId);
    }
    @PutMapping("/update/{instructorId}")
    public SimpleResponse updateInstructor(@RequestBody Instructor newInstructor, @PathVariable Long instructorId){
        return instructorService.updateIstructor(instructorId, newInstructor);
    }
    @GetMapping("/find/{instructorId}")
    public SaveInstructorDto findById(@PathVariable Long instructorId){
        return instructorService.findById(instructorId);
    }
    @PostMapping("/assing/{instructorId}/{companyId}")
    public SimpleResponse assingInstructorToCompany(@PathVariable Long instructorId, @PathVariable Long companyId){
        return instructorService.assingInstructorToCompany(instructorId, companyId);
    }
    @PostMapping("/assingToCourse/{instructorId}/{courseId}")
    public SimpleResponse assingInstructorToCourse(@PathVariable Long instructorId, @PathVariable Long courseId){
        return instructorService.assingInstructorToCourse(instructorId, courseId);
    }
}


