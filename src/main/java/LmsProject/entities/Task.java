package LmsProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Setter
@Getter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_gen")
    @SequenceGenerator(name = "task_gen", sequenceName = "task_seq", allocationSize =1, initialValue = 1)
    private Long id;
    private String taskName;
    private String taskTex;
    private LocalDate deadLine;

    @ManyToOne
    private Lesson lesson;
}
