package pl.sdacademy.service.student;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.Role;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.repository.AccountRepository;
import pl.sdacademy.repository.StudentRepository;

@Service
@Transactional
public class StudentCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCommandService.class);

    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public StudentCommandService(StudentRepository studentRepository, AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Long create(Student student) {
        student.getAccount().setRole(Role.ROLE_STUDENT);
        student.getAccount().setPassword(passwordEncoder.encodePassword(student.getAccount().getPassword(), null));
        accountRepository.save(student.getAccount());
        studentRepository.save(student);

        return student.getId();
    }

    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    public void update(Student student) {
        Student dbStudent = studentRepository.findOne(student.getId());
        if (dbStudent == null) {
            LOGGER.debug("Student with id " + student.getId() + " not found.");
        }
        dbStudent.setFirstName(student.getFirstName());
        dbStudent.setLastName(student.getLastName());
        dbStudent.setBirthdate(student.getBirthdate());
        dbStudent.setPhoneNumber(student.getPhoneNumber());
        dbStudent.getAccount().setEmail(student.getAccount().getEmail());
        dbStudent.getAccount().setPassword(student.getAccount().getPassword());
    }

    public void updatePhonenumber(Student student) {
        Student dbStudent = studentRepository.findOne(student.getId());
        if (dbStudent == null) {
            LOGGER.debug("Student with id " + student.getId() + " not found.");
        }
        dbStudent.setPhoneNumber(student.getPhoneNumber());
    }
}
