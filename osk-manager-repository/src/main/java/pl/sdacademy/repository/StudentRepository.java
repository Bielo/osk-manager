package pl.sdacademy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sdacademy.domain.entity.Student;

import javax.validation.constraints.Past;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName OR s.lastName = :lastName OR s.phoneNumber = :phoneNumber")
    List<Student> findStudentBySingleParam(@Param("firstName") String firstName,
                                    @Param("lastName") String lastName,
                                    @Param("phoneNumber") String phoneNumber);

    @Query("SELECT s FROM Student s WHERE s.firstName = :firstName AND s.lastName = :lastName AND s.phoneNumber = :phoneNumber")
    List<Student> findStudentByAllParams(@Param("firstName") String firstName,
                                                    @Param("lastName") String lastName,
                                                    @Param("phoneNumber") String phoneNumber);
}
