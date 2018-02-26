package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.service.account.AccountQueryService;
import pl.sdacademy.service.student.StudentCommandService;
import pl.sdacademy.service.student.StudentQueryService;
import pl.sdacademy.service.student.dto.SearchStudentDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;

    @Autowired
    public StudentController(StudentCommandService studentCommandService, StudentQueryService studentQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @RequestMapping("/scheduleStudent")
    public String showStudentSchedule(Model model) {
        return "/adminview/showScheduleStudent";
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @RequestMapping("/setScheduleStudent")
    public String planLessonStudent() {
        return "/adminview/DrivingLessonForm";
    }


    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @RequestMapping("/rateTeacher")
    public String rateTeacher() {
        return "/adminview/rateTeacher";
    }

    @PreAuthorize("hasRole('ROLE_STUDENT')")
    @RequestMapping("/showSettingsStudent")
    public String studentSettings() {
        return "/adminview/settingsStudent";
    }
}
