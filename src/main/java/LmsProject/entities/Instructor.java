package LmsProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "instructors")
@Setter
@Getter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_gen", sequenceName = "instructor_seq", allocationSize =1, initialValue = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Specialization specialization;


    @ManyToMany
    private List<Company> companies;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;
}
