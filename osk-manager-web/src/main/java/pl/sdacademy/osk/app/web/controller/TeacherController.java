package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.service.account.AccountCommandService;
import pl.sdacademy.service.account.AccountQueryService;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;
import pl.sdacademy.service.security.UserDetails;
import pl.sdacademy.service.teacher.TeacherCommandService;
import pl.sdacademy.service.teacher.TeacherQueryService;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final DrivingLessonQueryService drivingLessonQueryService;
    private final AccountQueryService accountQueryService;
    private final TeacherQueryService teacherQueryService;
    private final TeacherCommandService teacherCommandService;
    private final AccountCommandService accountCommandService;

    @Autowired
    public TeacherController(DrivingLessonQueryService drivingLessonQueryService, AccountQueryService accountQueryService, TeacherQueryService teacherQueryService, TeacherCommandService teacherCommandService, AccountCommandService accountCommandService) {
        this.drivingLessonQueryService = drivingLessonQueryService;
        this.accountQueryService = accountQueryService;
        this.teacherQueryService = teacherQueryService;
        this.teacherCommandService = teacherCommandService;
        this.accountCommandService = accountCommandService;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/showSchedule")
    public String teacherSchedule(Model model) {
        LOGGER.debug("show schedule for current Teacher");

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) loggedInUser.getPrincipal();
        Account account = accountQueryService.findAccountByID(userDetails.getAccountId());
        Teacher teacher = account.getTeacher();
        List<DrivingLessonDTO> drivingLessons = drivingLessonQueryService.findAllFutureDrivingLessonsForTeacher(teacher);
        model.addAttribute("lessons", drivingLessons);

        return "/teacherview/teacherSchedule";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/students")
    public String showStudentsForTeacher(Model model) {
        LOGGER.debug("show students for current Teacher");
        Long id = accountQueryService.findCurrentAccount().getTeacher().getId();

        Set<Student> students = drivingLessonQueryService.findMyStudents(id);
        model.addAttribute("students", students);

        return "/teacherview/studentsForTeachers";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/settings")
    public String teacherSettings() {
        LOGGER.debug("go to teacher's settings");

        return "/teacherview/settingsTeacher";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/editPhone", method = RequestMethod.GET)
    public String editPhoneNumber(Model model) {
        LOGGER.debug("change teacher's phone number");

        Teacher teacher = teacherQueryService.findTeacherByID(accountQueryService.findCurrentAccount().getTeacher().getId());
        model.addAttribute("teacher", teacher);

        return "/teacherview/editTeacherPhone";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/savePhone", method = RequestMethod.POST)
    public String savePhone(@ModelAttribute("teacher") Teacher teacher, RedirectAttributes redirectAttributes) {
        teacherCommandService.updatePhoneNumber(teacher);
        String message = String.format("Numer telefonu został zaktualizowany.");
        redirectAttributes.addFlashAttribute("info", message);

        return "redirect:/";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/editEmail", method = RequestMethod.GET)
    public String editEmail(Model model) {
        LOGGER.debug("change teacher's email");
        Account account = accountQueryService.findCurrentAccount();
        model.addAttribute("account", account);

        return "/teacherview/editEmail";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = "/saveEmail", method = RequestMethod.POST)
    public String saveEmail(@ModelAttribute("account") Account account, RedirectAttributes redirectAttributes) {
        accountCommandService.updateEmail(account);
        String message = String.format("Email został zaktualizowany");
        redirectAttributes.addFlashAttribute("info", message);
        redirectAttributes.addFlashAttribute("account", account);

        return "redirect:/";
    }
}
