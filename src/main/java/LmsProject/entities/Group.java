package LmsProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "groups")
@Setter
@Getter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize =1, initialValue = 1)
    private Long id;
    private String groupName;
    private String imageLink;
    private String descriptions;


    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Course>courses;
    @OneToMany(mappedBy = "group")
    private List<Student> students;

}
