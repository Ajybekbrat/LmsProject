package LmsProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Setter
@Getter
@NoArgsConstructor


public class Course {
    @Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
@SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize =1, initialValue = 1)
private Long id;
private String courseName;
private String description;
private LocalDate dateOfStart;
@ManyToOne
private Company company;
@ManyToMany(mappedBy = "courses", cascade = CascadeType.REMOVE)
    private List<Group>groups;
@OneToMany(mappedBy = "course")
    private List<Lesson>lessons;
   @ManyToOne
    private Instructor instructor;



}
