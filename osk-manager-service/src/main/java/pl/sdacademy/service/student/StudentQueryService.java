package pl.sdacademy.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.repository.StudentRepository;
import pl.sdacademy.service.student.dto.SearchStudentDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class StudentQueryService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentQueryService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> search(SearchStudentDTO searchStudentDTO) {

        List<Student> foundStudent = new ArrayList<>();

        if (!searchStudentDTO.getLastName().isEmpty()) {
            foundStudent = studentRepository.findAll().stream()
                    .filter(student -> student.getLastName().equals(searchStudentDTO.getLastName()))
                    .collect(Collectors.toList());

        }
        if (!searchStudentDTO.getFirstName().isEmpty()) {
            foundStudent = studentRepository.findAll().stream()
                    .filter(student -> student.getFirstName().equals(searchStudentDTO.getFirstName()))
                    .collect(Collectors.toList());
        }
        return foundStudent;
    }
}
