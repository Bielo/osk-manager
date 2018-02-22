package pl.sdacademy.service.drivinglesson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sdacademy.repository.DrivingLessonRepository;

@Service
@Transactional
public class DrivingLessonCommandService {

    private final DrivingLessonRepository drivingLessonRepository;

    @Autowired
    public DrivingLessonCommandService(DrivingLessonRepository drivingLessonRepository) {
        this.drivingLessonRepository = drivingLessonRepository;
    }
}
