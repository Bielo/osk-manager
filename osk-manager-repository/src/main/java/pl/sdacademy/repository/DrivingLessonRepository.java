package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sdacademy.domain.entity.DrivingLesson;

import java.util.Date;
import java.util.List;

public interface DrivingLessonRepository extends JpaRepository<DrivingLesson, Long> {

    @Query("SELECT s FROM DrivingLesson s WHERE s.lessonDay >= :dateNow")
    List<DrivingLesson> findAllFutureLessons(@Param("dateNow") Date date);
}
