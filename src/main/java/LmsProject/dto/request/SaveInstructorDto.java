package LmsProject.dto.request;

import LmsProject.entities.Specialization;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaveInstructorDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private Specialization specialization;
}
