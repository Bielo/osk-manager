package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.domain.entity.DrivingLesson;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.service.account.AccountCommandService;
import pl.sdacademy.service.account.AccountQueryService;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;
import pl.sdacademy.service.student.StudentCommandService;
import pl.sdacademy.service.student.StudentQueryService;
import pl.sdacademy.service.student.dto.DateDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final AccountQueryService accountQueryService;
    private final DrivingLessonQueryService drivingLessonQueryService;
    private final StudentQueryService studentQueryService;
    private final StudentCommandService studentCommandService;
    private final AccountCommandService accountCommandService;

    @Autowired
    public StudentController(AccountQueryService accountQueryService, DrivingLessonQueryService drivingLessonQueryService, StudentQueryService studentQueryService, StudentCommandService studentCommandService, AccountCommandService accountCommandService) {

        this.accountQueryService = accountQueryService;
        this.drivingLessonQueryService = drivingLessonQueryService;
        this.studentQueryService = studentQueryService;
        this.studentCommandService = studentCommandService;
        this.accountCommandService = accountCommandService;
    }

    private Long getStudentIdFromContext() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();
        Account account = accountQueryService.findByEmail(userName);
        return account.getStudent().getId();
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //  CustomDateEditor timeEditor = new CustomDateEditor(timeFormat, true);
        binder.registerCustomEditor(Date.class, editor);
        //  binder.registerCustomEditor(Date.class, timeEditor);
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
        DateDTO date = new DateDTO();
        model.addAttribute("date", date);
        return "/studentview/DrivingLessonForm";
    }

    @RequestMapping("/showTeachersForADay")
    public String showTeachersForADay(@ModelAttribute DateDTO dateDTO, Model model) {

        Date date = dateDTO.getDate();

        List<DrivingLesson> lessonsForADay = drivingLessonQueryService.findAllDrivingLessonsByLessonStartDay(date);

        model.addAttribute("lessons", lessonsForADay);

        return "/studentview/DrivingLessonForm";
    }

    @RequestMapping("/rateTeacher")
    public String rateTeacher() {
        return "/studentview/rateTeacher";
    }

    @RequestMapping("/showSettings")
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
        model.addAttribute("info", "Aktualizacja zakończona powodzeniem.");

        return "/studentview/studentSettings";
    }

    @RequestMapping(value = "/emailSettings", method = RequestMethod.GET)
    public String editEmail(Model model) {
        LOGGER.debug("edit email for current student");
        Account account = accountQueryService.findCurrentAccount();
        model.addAttribute("account", account);

        return "/studentview/emailSettings";
    }

    @RequestMapping(value = "/saveEmail", method = RequestMethod.POST)
    public String saveStudentEmail(@ModelAttribute("account") Account account, Model model) {
        accountCommandService.updateEmail(account);
        String message = String.format("Email został zaktualizowany");
        model.addAttribute("info", message);
        model.addAttribute("account", account);

        return "/studentview/studentSettings";
    }
}
