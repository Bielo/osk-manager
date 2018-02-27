package pl.sdacademy.service.teacher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.domain.entity.Role;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.repository.AccountRepository;
import pl.sdacademy.repository.TeacherRepository;
import pl.sdacademy.service.student.StudentCommandService;

import javax.transaction.Transactional;

@Service
@Transactional
public class TeacherCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCommandService.class);

    private final TeacherRepository teacherRepository;
    private final AccountRepository accountRepository;
    private final org.springframework.security.authentication.encoding.PasswordEncoder passwordEncoder;

    @Autowired
    public TeacherCommandService(TeacherRepository teacherRepository, AccountRepository accountRepository, org.springframework.security.authentication.encoding.PasswordEncoder passwordEncoder) {
        this.teacherRepository = teacherRepository;
        this.accountRepository = accountRepository;

        this.passwordEncoder = passwordEncoder;
    }

    public Long create(Teacher teacher){
        teacher.getAccount().setRole(Role.ROLE_TEACHER);
        teacher.getAccount().setPassword(passwordEncoder.encodePassword(teacher.getAccount().getPassword(), null));
        accountRepository.save(teacher.getAccount());
        teacherRepository.save(teacher);

        return teacher.getId();
    }

    public void update(Teacher teacher) {
        Teacher dbTeacher = teacherRepository.findOne(teacher.getId());
        if (dbTeacher == null) {
            LOGGER.debug("Teacher with id " + teacher.getId() + " not found.");
        }
        dbTeacher.setFirstName(teacher.getFirstName());
        dbTeacher.setLastName(teacher.getLastName());
        dbTeacher.setPhoneNumber(teacher.getPhoneNumber());
        dbTeacher.getAccount().setEmail(teacher.getAccount().getEmail());
        dbTeacher.getAccount().setPassword(teacher.getAccount().getPassword());
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findOne(id);
        if (teacher == null) {
            LOGGER.debug("Teacher with id " + id + " not found.");
        }

        teacherRepository.delete(teacher);
    }

    public void updatePhoneNumber(Teacher teacher) {
        Teacher dbTeacher = teacherRepository.findOne(teacher.getId());
        if (dbTeacher == null) {
            LOGGER.debug("Teacher with id " + teacher.getId() + " not found.");
        }
        dbTeacher.setPhoneNumber(teacher.getPhoneNumber());
    }

}
