package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.service.account.AccountQueryService;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;
import pl.sdacademy.service.student.StudentQueryService;
import pl.sdacademy.service.teacher.TeacherCommandService;
import pl.sdacademy.service.teacher.TeacherQueryService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/teacher/")
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final TeacherCommandService teacherCommandService;
    private final TeacherQueryService teacherQueryService;
    private final StudentQueryService studentQueryService;
    private final DrivingLessonQueryService drivingLessonQueryService;
    private final AccountQueryService accountQueryService;

    @Autowired
    public TeacherController(TeacherCommandService teacherCommandService, TeacherQueryService teacherQueryService, StudentQueryService studentQueryService, DrivingLessonQueryService drivingLessonQueryService, AccountQueryService accountQueryService) {
        this.teacherCommandService = teacherCommandService;
        this.teacherQueryService = teacherQueryService;
        this.studentQueryService = studentQueryService;
        this.drivingLessonQueryService = drivingLessonQueryService;
        this.accountQueryService = accountQueryService;
    }



    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/showSchedule")
    public String teacherSchedule(Model model) {
        LOGGER.debug("show schedule for current Teacher");

        //FIXME poprawić to zapytanie na wyszukiwanie konretnego harmonogramu dla Instruktora

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();
        Account account = accountQueryService.findByEmail(userName);
        Teacher teacher = account.getTeacher();
        List<DrivingLessonDTO> drivingLessons = drivingLessonQueryService.findAllFutureDrivingLessonsForTeacher(teacher);
        model.addAttribute("lessons", drivingLessons);
        return "/teacherview/teacherSchedule";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/students")
    public String showStudentsForTeacher(Model model) {
        LOGGER.debug("show students for current Teacher");

        Long id = getTeacherIdFromContext();

        Set<Student> students = drivingLessonQueryService.findMyStudents(id);
        model.addAttribute("students", students);

        return "/teacherview/studentsForTeachers";
    }

    private Long getTeacherIdFromContext() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

        String userName = loggedInUser.getName();

        Account account = accountQueryService.findByEmail(userName);
        return account.getTeacher().getId();
    }


}
