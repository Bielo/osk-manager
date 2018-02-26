package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.service.account.AccountQueryService;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;
import pl.sdacademy.service.student.StudentCommandService;
import pl.sdacademy.service.student.StudentQueryService;

import java.util.List;

@Controller
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;
    private final AccountQueryService accountQueryService;
    private final DrivingLessonQueryService drivingLessonQueryService;

    @Autowired
    public StudentController(StudentCommandService studentCommandService, StudentQueryService studentQueryService, AccountQueryService accountQueryService, DrivingLessonQueryService drivingLessonQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
        this.accountQueryService = accountQueryService;
        this.drivingLessonQueryService = drivingLessonQueryService;
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @RequestMapping("/scheduleStudent")
    public String showStudentSchedule(Model model) {
        LOGGER.debug("show schedule for current student");

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();
        Account account = accountQueryService.findByEmail(userName);
        Student student = account.getStudent();
        List<DrivingLessonDTO> drivingLessons = drivingLessonQueryService.findAllFutureDrivingLessonsForStudent(student);
        model.addAttribute("lessons", drivingLessons);
        return "/studentview/showScheduleStudent";
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @RequestMapping("/setScheduleStudent")
    public String planLessonStudent() {
        return "/studentview/DrivingLessonForm";
    }


    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @RequestMapping("/rateTeacher")
    public String rateTeacher() {
        return "/studentview/rateTeacher";
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @RequestMapping("/showSettingsStudent")
    public String studentSettings() {
        return "/studentview/settingsStudent";
    }
}
