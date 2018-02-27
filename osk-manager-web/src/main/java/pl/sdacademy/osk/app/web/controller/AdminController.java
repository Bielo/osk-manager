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
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;
import pl.sdacademy.service.student.StudentCommandService;
import pl.sdacademy.service.student.StudentQueryService;
import pl.sdacademy.service.student.dto.SearchStudentDTO;
import pl.sdacademy.service.teacher.TeacherCommandService;
import pl.sdacademy.service.teacher.TeacherQueryService;
import pl.sdacademy.service.teacher.dto.SearchTeacherDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    private final StudentCommandService studentCommandService;
    private final StudentQueryService studentQueryService;
    private final TeacherCommandService teacherCommandService;
    private final TeacherQueryService teacherQueryService;
    private final DrivingLessonQueryService drivingLessonQueryService;

    @Autowired
    public AdminController(StudentCommandService studentCommandService, StudentQueryService studentQueryService, TeacherCommandService teacherCommandService, TeacherQueryService teacherQueryService, DrivingLessonQueryService drivingLessonQueryService) {
        this.studentCommandService = studentCommandService;
        this.studentQueryService = studentQueryService;
        this.teacherCommandService = teacherCommandService;
        this.teacherQueryService = teacherQueryService;
        this.drivingLessonQueryService = drivingLessonQueryService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = {"/addStudent"}, method = RequestMethod.GET)
    public String addStudent(Model model) {
        LOGGER.debug("add student is executed");
        Student student = new Student();
        model.addAttribute("student", student);

        return "/adminview/studentForm";
    }

    @RequestMapping(value = {"/saveStudent"})
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        LOGGER.debug("save student is executed");
        if (student.getId() == null) {
            int sizeBefore = studentQueryService.studentCount();
            studentCommandService.create(student);
            int afterSize = studentQueryService.studentCount();
            if(sizeBefore == afterSize){
                redirectAttributes.addFlashAttribute("info", "Nie udało się dodać kursanta.");
            } else {
                redirectAttributes.addFlashAttribute("info", "Udało się dodać kursanta!");
            }
        } else {
            studentCommandService.update(student);
            redirectAttributes.addFlashAttribute("info", "Udało się pomyślnie zaktualizować dane wybranego kursanta.");
        }

        return "redirect:/";
    }

    @RequestMapping(value = {"/showStudentss"})
    public String showAllStudents(Model model) {
        LOGGER.debug("show all students is executed!");
        List<Student> allStudents = studentQueryService.findAllStudents();

        model.addAttribute("students", allStudents);

        return "/adminview/showStudents";
    }

    @RequestMapping(value = "/findStudent", method = RequestMethod.GET)
    public String findStudent(Model model) {
        LOGGER.debug("find student is executed!");
        model.addAttribute("searchStudent", new SearchStudentDTO());

        return "/adminview/findStudent";
    }

    @RequestMapping(value = "/findStudent", method = RequestMethod.POST)
    public String findStudentByName(@ModelAttribute SearchStudentDTO searchStudent, Model model) {
        LOGGER.debug("show found student is executed!");
        List<Student> foundStudent = studentQueryService.search(searchStudent);
        model.addAttribute("foundStudent", foundStudent);

        return "/adminview/foundStudent";
    }

    @RequestMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        LOGGER.debug("is executed!");
        Student student = studentQueryService.findStudentByID(id);
        String message = String.format("Udało się usunąć kursanta %s %s", student.getFirstName(), student.getLastName());
        studentCommandService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("info", message);

        return "redirect:/";
    }

    @RequestMapping("/student/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model) {
        LOGGER.debug("Edit Student");

        Student student = studentQueryService.findStudentByID(id);
        model.addAttribute("student", student);

        return "/adminview/studentForm";
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String addTeacher(Model model) {
        LOGGER.debug("add teacher is executed");
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "/adminview/teacherForm";
    }

    @RequestMapping(value = {"/saveTeacher"}, method = RequestMethod.POST)
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, RedirectAttributes redirectAttributes){
        LOGGER.debug("save teacher is executed");
        if(teacher.getId() == null){
            int sizeBefore = teacherQueryService.teacherCount();
            teacherCommandService.create(teacher);
            int afterSize = teacherQueryService.teacherCount();
            if(sizeBefore == afterSize){
                redirectAttributes.addFlashAttribute("info", "Nie udało się dodać instruktora");
            } else {
                redirectAttributes.addFlashAttribute("info", "Udało sie dodać instruktora!");
            }
        } else {
            teacherCommandService.update(teacher);
            String message = String.format("Udało się pomyślnie zaktualizować dane wybranego instruktora.");
            redirectAttributes.addFlashAttribute("info", message);
        }

        return "redirect:/";
    }

    @RequestMapping(value = {"/showTeacherss"})
    public String showAllTeachers(Model model) {
        LOGGER.debug("show all teachers is executed");
        List<Teacher> allTeachers = teacherQueryService.findAllTeachers();
        model.addAttribute("teachers", allTeachers);

        return "/adminview/showTeachers";
    }

    @RequestMapping(value = "/findTeacher", method = RequestMethod.GET)
    public String findTeacher(Model model) {
        LOGGER.debug("find teacher is executed!");
        model.addAttribute("searchTeacher", new SearchTeacherDTO());

        return "/adminview/findTeacher";
    }

    @RequestMapping(value = "/findTeacher", method = RequestMethod.POST)
    public String findTeacherByName(@ModelAttribute SearchTeacherDTO searchTeacher, Model model) {
        LOGGER.debug("show found teacher is executed!");
        List<Teacher> foundTeacher = teacherQueryService.search(searchTeacher);
        model.addAttribute("searchTeacher", new SearchTeacherDTO());
        model.addAttribute("foundTeacher", foundTeacher);

        return "/adminview/foundTeacher";
    }

    @RequestMapping(value = {"/teacher/delete/{id}"})
    public String deleteTeacher(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        LOGGER.debug("delete teacher is executed!");
        Teacher teacher = teacherQueryService.findTeacherByID(id);
        String message = String.format("Udało się usunąć instruktora %s %s", teacher.getFirstName(), teacher.getLastName());
        teacherCommandService.deleteTeacher(id);
        redirectAttributes.addFlashAttribute("info", message);

        return "redirect:/";
    }

    @RequestMapping(value = {"/teacher/edit/{id}"})
    public String editTeacher(@PathVariable("id") Long id, Model model){
        LOGGER.debug("edit teacher is executed!");
        Teacher teacher = teacherQueryService.findTeacherByID(id);
        model.addAttribute("teacher", teacher);

        return "/adminview/teacherForm";
    }

    @RequestMapping(value = "/showSchedule", method = RequestMethod.GET)
    public String schedule(Model model) {
        LOGGER.debug("is executed");
        List<DrivingLessonDTO> drivingLessonDTOList = drivingLessonQueryService.findAllFutureDrivingLessons();
        model.addAttribute("lessons", drivingLessonDTOList);

        return "/adminview/schedule";
    }
}
