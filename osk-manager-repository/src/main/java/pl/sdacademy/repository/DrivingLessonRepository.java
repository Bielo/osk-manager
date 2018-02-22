package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.domain.entity.DrivingLesson;

public interface DrivingLessonRepository extends JpaRepository<DrivingLesson, Long> {


}
