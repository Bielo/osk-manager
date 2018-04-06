package pl.sdacademy.service.drivinglesson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.domain.entity.DrivingLessonUnconfirmed;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.repository.DrivingLessonRepository;
import pl.sdacademy.repository.DrivingLessonUnconfirmedRepository;
import pl.sdacademy.repository.StudentRepository;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DrivingLessonCommandService {

    private final DrivingLessonRepository drivingLessonRepository;
    private final StudentRepository studentRepository;
    private final DrivingLessonUnconfirmedRepository drivingLessonUnconfirmedRepository;

    @Autowired
    public DrivingLessonCommandService(DrivingLessonRepository drivingLessonRepository, StudentRepository studentRepository, DrivingLessonUnconfirmedRepository drivingLessonUnconfirmedRepository) {
        this.drivingLessonRepository = drivingLessonRepository;
        this.studentRepository = studentRepository;
        this.drivingLessonUnconfirmedRepository = drivingLessonUnconfirmedRepository;
    }

    public void createScheduleForInstructor(Date date, Date startWorkTime, Date stopWorkTime, Teacher teacher) {

        List<DrivingLesson> drivingLessons = drivingLessonRepository.findDrivingLessonsByDateAndTeacherInIt(date, teacher);

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
            if (!drivingLessons.contains(drivingLesson)) {
                drivingLessonRepository.save(drivingLesson);
            }

        }


    }

    public void reserveLesson(Long lessonId, Long studentId) {
        DrivingLesson drivingLesson = drivingLessonRepository.findOne(lessonId);

        Student student = studentRepository.findOne(studentId);

        DrivingLessonUnconfirmed drivingLessonUnconfirmed = new DrivingLessonUnconfirmed(drivingLesson, student);
        drivingLessonUnconfirmedRepository.save(drivingLessonUnconfirmed);
    }
}
