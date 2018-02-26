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
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.service.account.AccountQueryService;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;
import pl.sdacademy.service.student.StudentCommandService;
import pl.sdacademy.service.student.StudentQueryService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final AccountQueryService accountQueryService;
    private final DrivingLessonQueryService drivingLessonQueryService;
    private final StudentQueryService studentQueryService;
    private final StudentCommandService studentCommandService;

    @Autowired
    public StudentController(AccountQueryService accountQueryService, DrivingLessonQueryService drivingLessonQueryService, StudentQueryService studentQueryService, StudentCommandService studentCommandService) {

        this.accountQueryService = accountQueryService;
        this.drivingLessonQueryService = drivingLessonQueryService;
        this.studentQueryService = studentQueryService;
        this.studentCommandService = studentCommandService;
    }

    private Long getStudentIdFromContext() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();
        Account account = accountQueryService.findByEmail(userName);
        return account.getStudent().getId();
    }

    @RequestMapping("/schedule")
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

    @RequestMapping("/setSchedule")
    public String planLessonStudent(Model model) {
        DrivingLesson drivingLesson = new DrivingLesson();
        model.addAttribute("drivingLesson", drivingLesson);
        return "/studentview/DrivingLessonForm";
    }

    @RequestMapping("/rateTeacher")
    public String rateTeacher() {
        return "/studentview/rateTeacher";
    }

    @RequestMapping("/showSettingsStudent")
    public String showStudentSettings(){
        LOGGER.debug("show student settings is executed!");
        return "/studentview/studentSettings";
    }

    @RequestMapping(value = "/phonenumberSettings", method = RequestMethod.GET)
    public String editStudentPhonenumber(Model model) {
        LOGGER.debug("edit phonenumber for current student");
        Student student = studentQueryService.findStudentByID(getStudentIdFromContext());
        model.addAttribute("student", student);

        return "/studentview/phonenumberSettings";
    }

    @RequestMapping(value = "/savePhonenumber", method = RequestMethod.POST)
    public String saveStudentPhonenumber(@ModelAttribute("student") Student student, Model model) {
        LOGGER.debug("save phonenumber for current student");
        studentCommandService.updatePhonenumber(student);
        model.addAttribute("info", "Udało się pomyślnie zaktualizować numer telefonu.");

        return "/studentview/studentSettings";
    }
}
