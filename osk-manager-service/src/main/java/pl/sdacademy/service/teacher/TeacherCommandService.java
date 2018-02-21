package pl.sdacademy.service.teacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.repository.TeacherRepository;
import pl.sdacademy.service.student.StudentCommandService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeacherCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCommandService.class);

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherCommandService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Long create(Teacher teacher){
        teacherRepository.save(teacher);

        return teacher.getId();
    }

    public int teacherCount(){
        return teacherRepository.findAll().size();
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

//    public void update(Teacher teacher) {
//        Teacher dbTeacher = teacherRepository.findOne(teacher.getId());
//        if (dbTeacher == null) {
//            LOGGER.debug("Teacher with id " + teacher.getId() + " not found.");
//        }
//        dbTeacher.setFirstName(teacher.getFirstName());
//        dbTeacher.setLastName(teacher.getLastName());
//        dbTeacher.setPhoneNumber(teacher.getPhoneNumber());
//        dbTeacher.setEmail(teacher.getEmail());
//    }
//
//    public void delete(Long id) {
//        Teacher teacher = teacherRepository.findOne(id);
//        if (teacher == null) {
//            LOGGER.debug("Teacher with id " + id + " not found.");
//        }
//
//        teacherRepository.delete(teacher);
//    }
}
