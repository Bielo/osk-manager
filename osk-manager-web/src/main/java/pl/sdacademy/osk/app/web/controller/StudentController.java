package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.service.student.StudentCommandService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final StudentCommandService studentCommandService;

    @Autowired
    public StudentController(StudentCommandService studentCommandService) {
        this.studentCommandService = studentCommandService;
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

        return "studentForm";
    }

    @RequestMapping(value = {"/saveStudent"})
    public String saveStudent(@ModelAttribute("student") Student student, Model model) {
        LOGGER.debug("save student is executed");
        int sizeBefore = studentCommandService.studentCount();
        studentCommandService.create(student);
        int afterSize = studentCommandService.studentCount();
        if (sizeBefore == afterSize) {
            model.addAttribute("info", "Nie udało się dodać użytkownika");
        } else {
            model.addAttribute("info", "Udało się dodać użytkownika!");
        }
        return "adminMain";
    }

    @RequestMapping(value = {"/showStudentss"})
    public String showAllStudents(Model model) {
        LOGGER.debug("show all students is executerd");
        List<Student> allStudents = studentCommandService.findAllStudents();

        model.addAttribute("students", allStudents);

        return "showStudents";
    }
}
