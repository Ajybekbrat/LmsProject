package LmsProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lessons")
@Setter
@Getter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_seq", allocationSize =1, initialValue = 1)
    private Long id;
    private String lessonName;


    @OneToMany(mappedBy = "lesson")
    private List<Task>tasks;
    @ManyToOne
    private Course course;
}
