package LmsProject.dto.request;

import LmsProject.entities.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private StudyFormat studyFormat;
}
