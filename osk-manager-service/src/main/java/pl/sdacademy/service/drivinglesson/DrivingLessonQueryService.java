package pl.sdacademy.service.drivinglesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.repository.DrivingLessonRepository;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;

import java.util.ArrayList;
import java.util.Date;
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

    public List<DrivingLessonDTO> findAllDrivingLessons() {
        List<DrivingLesson> drivingLessonList = drivingLessonRepository.findAllFutureLessons(new Date());
        List<DrivingLessonDTO> drivingLessonDTOList = new ArrayList<>();

        for (int i = 0; i < drivingLessonList.size(); i++) {
            DrivingLesson drivingLesson = drivingLessonList.get(i);

            String studentName = drivingLesson.getStudent().getFirstName() + " "
                    + drivingLesson.getTeacher().getLastName();
            String teacherName = drivingLesson.getTeacher().getFirstName() + " "
                    + drivingLesson.getTeacher().getLastName();

            DrivingLessonDTO drivingLessonDTO = new DrivingLessonDTO();
            drivingLessonDTO.setStudentFirstAndLastName(studentName);
            drivingLessonDTO.setTeacherFirstAndLastName(teacherName);
            drivingLessonDTO.setLessonDay(drivingLesson.getLessonDay());
            drivingLessonDTO.setLessonStartTime(drivingLesson.getLessonStartTime());
            drivingLessonDTO.setLessonStopTime(drivingLesson.getLessonStopTime());

            drivingLessonDTOList.add(drivingLessonDTO);

        }
        return drivingLessonDTOList;
    }
}
