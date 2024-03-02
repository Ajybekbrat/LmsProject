package LmsProject.dto.request;

import LmsProject.dto.response.SimpleResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
public class TaskDto {
    private String taskName;
    private String taskTex;
    private LocalDate deadLine;


}
