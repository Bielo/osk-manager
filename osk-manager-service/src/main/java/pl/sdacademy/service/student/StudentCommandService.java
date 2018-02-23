package pl.sdacademy.service.student;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.repository.AccountRepository;
import pl.sdacademy.repository.StudentRepository;

@Service
@Transactional
public class StudentCommandService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCommandService.class);

    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public StudentCommandService(StudentRepository studentRepository, AccountRepository accountRepository) {
        this.studentRepository = studentRepository;
        this.accountRepository = accountRepository;
    }

    public Long create(Student student) {
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
    }
}
