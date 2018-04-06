package pl.sdacademy.service.drivinglesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.repository.DrivingLessonRepository;
import pl.sdacademy.repository.TeacherRepository;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DrivingLessonQueryService {

    private final DrivingLessonRepository drivingLessonRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public DrivingLessonQueryService(DrivingLessonRepository drivingLessonRepository, TeacherRepository teacherRepository) {
        this.drivingLessonRepository = drivingLessonRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<DrivingLessonDTO> findAllFutureDrivingLessons() {
        List<DrivingLesson> drivingLessonList = drivingLessonRepository.findAllFutureLessons(new Date());
        List<DrivingLessonDTO> drivingLessonDTOList = getDrivingLessonDTO(drivingLessonList);
        return drivingLessonDTOList;
    }


    public List<DrivingLessonDTO> findAllFutureDrivingLessonsForTeacher(Long id) {
        Teacher teacher = teacherRepository.findOne(id);
        List<DrivingLesson> drivingLessonList = drivingLessonRepository.findDrivingLessonsForTeacher(teacher, new Date());

//        List<DrivingLesson> forOneTeacher = drivingLessonList.stream()
//                .filter(drivingLesson -> drivingLesson.getTeacher().getId() == id)
//                .collect(Collectors.toList());
        List<DrivingLessonDTO> drivingLessonDTOList = getDrivingLessonDTO(drivingLessonList.stream()
        .filter(s -> s.getStudent() != null)
        .collect(Collectors.toList()));
        return drivingLessonDTOList;
    }

    private List<DrivingLessonDTO> getDrivingLessonDTO(List<DrivingLesson> drivingLessonList) {
        List<DrivingLessonDTO> drivingLessonDTOList = new ArrayList<>();

        for (int i = 0; i < drivingLessonList.size(); i++) {
            DrivingLesson drivingLesson = drivingLessonList.get(i);

            String studentName = drivingLesson.getStudent().getFirstName() + " "
                    + drivingLesson.getStudent().getLastName();
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

    public Set<Student> findMyStudents(Long teacherId) {
        // FIXME should be form logged user context, dodatkowo obecnie jak ma kilka lekcji z jednym kursantem, to zwraca tego samego kursanta kilka razy, chyba jakaś kolekcja bez powtorek by sie przydala

        Teacher teacher = teacherRepository.findOne(teacherId);
        return drivingLessonRepository.findStudentForTeacher(teacher).stream()
                .filter(s -> s.getStudent() != null)
                .map(DrivingLesson::getStudent)
                .collect(Collectors.toSet());
    }

    public List<DrivingLessonDTO> findAllFutureDrivingLessonsForStudent(Student student) {
        List<DrivingLesson> drivingLessonList = drivingLessonRepository.findDrivingLessonsForStudent(student, new Date());
        List<DrivingLessonDTO> drivingLessonDTOList = getDrivingLessonDTO(drivingLessonList);
        return  drivingLessonDTOList;
    }

    public List<DrivingLesson> findAllDrivingLessonsByLessonStartDay(Date date, Teacher teacher) {
        List<DrivingLesson> drivingLessons = drivingLessonRepository.findDrivingLessonsByDateAndTeacherInIt(date, teacher);
        return drivingLessons;
    }
}
