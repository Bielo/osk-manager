package pl.sdacademy.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.repository.StudentRepository;
import pl.sdacademy.service.student.dto.SearchStudentDTO;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentQueryService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentQueryService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public int studentCount() {
        return studentRepository.findAll().size();
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student findStudentByID(Long id) {
        return studentRepository.findOne(id);
    }

    public List<Student> search(SearchStudentDTO searchStudentDTO) {
        List<Student> result;
        if (searchStudentDTO.getFirstName().isEmpty() || searchStudentDTO.getLastName().isEmpty()) {
            result = studentRepository.findStudentByName(searchStudentDTO.getFirstName(), searchStudentDTO.getLastName());

        } else {
            result = studentRepository.findStudentByFirstNameAndLastName(searchStudentDTO.getFirstName(), searchStudentDTO.getLastName());
        }

        return result;
    }
}
