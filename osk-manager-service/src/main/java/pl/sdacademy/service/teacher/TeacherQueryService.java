package pl.sdacademy.service.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.repository.TeacherRepository;
import pl.sdacademy.service.teacher.dto.SearchTeacherDTO;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeacherQueryService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherQueryService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public int teacherCount(){
        return teacherRepository.findAll().size();
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher findTeacherByID(Long id){
        return teacherRepository.findOne(id);
    }

    public List<Teacher> search(SearchTeacherDTO searchTeacherDTO){
        List<Teacher> result;
        if (searchTeacherDTO.getFirstName().isEmpty() || searchTeacherDTO.getLastName().isEmpty()) {
            result = teacherRepository.findTeacherBySingleParam(searchTeacherDTO.getFirstName(), searchTeacherDTO.getLastName());
        } else {
            result = teacherRepository.findTeacherByAllParams(searchTeacherDTO.getFirstName(), searchTeacherDTO.getLastName());
        }
        return result;
    }
}
