package yteintern.springapplication.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yteintern.springapplication.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student , Long> {

}
