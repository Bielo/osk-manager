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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.sdacademy.domain.entity.Account;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.service.account.AccountCommandService;
import pl.sdacademy.service.account.AccountQueryService;
import pl.sdacademy.service.drivinglesson.DrivingLessonCommandService;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;
import pl.sdacademy.service.security.UserDetails;
import pl.sdacademy.service.teacher.TeacherCommandService;
import pl.sdacademy.service.teacher.TeacherQueryService;
import pl.sdacademy.service.teacher.dto.CreateScheduleDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

    private final DrivingLessonQueryService drivingLessonQueryService;
    private final AccountQueryService accountQueryService;
    private final DrivingLessonCommandService drivingLessonCommandService;
    private final TeacherQueryService teacherQueryService;
    private final TeacherCommandService teacherCommandService;
    private final AccountCommandService accountCommandService;



    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
      //  CustomDateEditor timeEditor = new CustomDateEditor(timeFormat, true);
        binder.registerCustomEditor(Date.class, editor);
      //  binder.registerCustomEditor(Date.class, timeEditor);
    }


    @Autowired
    public TeacherController(DrivingLessonQueryService drivingLessonQueryService, AccountQueryService accountQueryService, DrivingLessonCommandService drivingLessonCommandService,
                             TeacherQueryService teacherQueryService, TeacherCommandService teacherCommandService, AccountCommandService accountCommandService) {
        this.drivingLessonQueryService = drivingLessonQueryService;
        this.accountQueryService = accountQueryService;
        this.drivingLessonCommandService = drivingLessonCommandService;
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
    @RequestMapping(value = "/setSchedule")
    public String setSchedule(Model model) {
        LOGGER.debug("setschedule jest wykonywany");
        model.addAttribute("schedule", new CreateScheduleDTO());
        return "/teacherview/setTeacherSchedule";
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @RequestMapping(value = {"/createSchedule"})
    public String createSchedule(@ModelAttribute CreateScheduleDTO scheduleDTO) {
        LOGGER.debug("kriejt skedul jest wykonywany");
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

        String userName = loggedInUser.getName();

        Account account = accountQueryService.findByEmail(userName);

        Teacher teacher = account.getTeacher();

        Date startWorkHour = new Date();
        String[] startWork = scheduleDTO.getStartWorkHour().split(":");
        startWorkHour.setHours(Integer.valueOf(startWork[0]));
        startWorkHour.setMinutes(Integer.valueOf(startWork[1]));
        startWorkHour.setSeconds(00);

        Date stopWorkHour = new Date();
        String[] stopWork = scheduleDTO.getStopWorkHour().split(":");
        stopWorkHour.setHours(Integer.valueOf(stopWork[0]));
        stopWorkHour.setMinutes(Integer.valueOf(stopWork[1]));
        stopWorkHour.setSeconds(00);

        drivingLessonCommandService.createScheduleForInstructor(scheduleDTO.getDay(), startWorkHour, stopWorkHour, teacher);

        return "redirect:/";
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
