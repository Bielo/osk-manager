package pl.sdacademy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.domain.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
