package pl.sdacademy.service.drivinglesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.repository.DrivingLessonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class DrivingLessonQueryService {

    private final DrivingLessonRepository drivingLessonRepository;

    @Autowired
    public DrivingLessonQueryService(DrivingLessonRepository drivingLessonRepository) {
        this.drivingLessonRepository = drivingLessonRepository;
    }

    public List<String> findAllDrivingLessons() {
        List<DrivingLesson> drivingLessons = drivingLessonRepository.findAll();
        List<String> drivingLessonsInString = new ArrayList<>();



        for (int i = 0; i < drivingLessons.size(); i++) {
            StringBuilder sb = new StringBuilder();
            DrivingLesson drivingLesson = drivingLessons.get(i);

            sb.append(drivingLesson.getPk().getStudent().getFirstName());
            sb.append(" ");
            sb.append(drivingLesson.getPk().getStudent().getLastName());
            sb.append(" będzie jeździł z ");
            sb.append(drivingLesson.getPk().getTeacher().getFirstName());
            sb.append(" ");
            sb.append(drivingLesson.getPk().getTeacher().getLastName());
            sb.append(" dnia: ");
            sb.append(drivingLesson.getLessonStart().getDate());
            sb.append(drivingLesson.getLessonStart().getMonth());
            sb.append(drivingLesson.getLessonStart().getYear());
            sb.append(" o godzinie ");
            sb.append(drivingLesson.getLessonStart().getHours());
            sb.append(":");
            sb.append(drivingLesson.getLessonStart().getMinutes());
            sb.append(". Jazda zakończy się o ");
            sb.append(drivingLesson.getLessonStop().getHours());
            sb.append(":");
            sb.append(drivingLesson.getLessonStop().getMinutes());
            sb.append(".");

            drivingLessonsInString.add(sb.toString());

        }

        return drivingLessonsInString;
    }
}
