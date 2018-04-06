package pl.sdacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.domain.entity.DrivingLessonUnconfirmed;

public interface DrivingLessonUnconfirmedRepository extends JpaRepository<DrivingLessonUnconfirmed, Long> {

    DrivingLessonUnconfirmed findDrivingLessonUnconfirmedByDrivingLesson(DrivingLesson drivingLesson);
}
