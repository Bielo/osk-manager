package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.domain.entity.Teacher;

import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

public interface DrivingLessonRepository extends JpaRepository<DrivingLesson, Long> {

    @Query("SELECT s FROM DrivingLesson s WHERE s.lessonDay >= :dateNow")
    List<DrivingLesson> findAllFutureLessons(@Param("dateNow") Date date);

    @Query("SELECT dl FROM DrivingLesson dl LEFT JOIN FETCH dl.student s WHERE dl.teacher = :teacher")
    List<DrivingLesson> findStudentForTeacher(@Param("teacher") Teacher teacher);

    @Query("SELECT dl FROM DrivingLesson dl WHERE dl.teacher = :teacher AND dl.lessonDay >= :dateNow")
    List<DrivingLesson> findDrivingLessonsForTeacher(@Param("teacher")Teacher teacher, @Param("dateNow") Date date);

    @Query("SELECT dl FROM DrivingLesson  dl WHERE dl.student = :student AND dl.lessonDay >= :dateNow")
    List<DrivingLesson> findDrivingLessonsForStudent(@Param("student") Student student, @Param("dateNow") Date date);
}
