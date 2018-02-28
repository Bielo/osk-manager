package pl.sdacademy.service.drivinglesson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.repository.DrivingLessonRepository;

import java.util.Date;

@Service
@Transactional
public class DrivingLessonCommandService {

    private final DrivingLessonRepository drivingLessonRepository;

    @Autowired
    public DrivingLessonCommandService(DrivingLessonRepository drivingLessonRepository) {
        this.drivingLessonRepository = drivingLessonRepository;
    }

    public void createScheduleForInstructor(Date date, Date startWorkTime, Date stopWorkTime, Teacher teacher) {

        for (int i = startWorkTime.getHours(); i < stopWorkTime.getHours() ; i++) {
            Date datestart = new Date();
            datestart.setHours(i);
            datestart.setMinutes(00);
            datestart.setSeconds(00);
            Date datestop = new Date();
            datestop.setHours(i + 1);
            datestop.setMinutes(00);
            datestop.setSeconds(00);
            DrivingLesson drivingLesson = new DrivingLesson(null, teacher, date, datestart, datestop, false);
            drivingLessonRepository.save(drivingLesson);
        }


    }
}
