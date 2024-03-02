package LmsProject.repository;

import LmsProject.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {
}
