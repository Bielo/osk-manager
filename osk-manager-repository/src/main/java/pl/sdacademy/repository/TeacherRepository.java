package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.sdacademy.domain.entity.Teacher;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.firstName = :firstName OR t.lastName = :lastName")
    List<Teacher> findTeacherBySingleParam(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT t FROM Teacher t WHERE t.firstName = :firstName AND t.lastName = :lastName")
    List<Teacher> findTeacherByAllParams(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
