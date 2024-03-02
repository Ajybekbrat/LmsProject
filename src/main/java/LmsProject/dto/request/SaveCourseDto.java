package LmsProject.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SaveCourseDto {
    private String courseName;
    private String description;
    private LocalDate dateOfStart;
}
