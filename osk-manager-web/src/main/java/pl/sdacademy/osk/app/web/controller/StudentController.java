package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.sdacademy.domain.entity.Student;
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

        if (student.getId() == null) {
            int sizeBefore = studentCommandService.studentCount();
            studentCommandService.create(student);
            int afterSize = studentCommandService.studentCount();
            if (sizeBefore == afterSize) {
                model.addAttribute("info", "Nie udało się dodać użytkownika");
            } else {
                model.addAttribute("info", "Udało się dodać użytkownika!");
            }
            return "adminMain";
        } else {
            studentCommandService.update(student);
            model.addAttribute("info", "Udało się pomyślnie zaktualizować dane wybranego kursanta.");

            return "adminMain";
        }

    }

    @RequestMapping(value = {"/showStudentss"})
    public String showAllStudents(Model model) {
        LOGGER.debug("show all students is executerd");
        List<Student> allStudents = studentCommandService.findAllStudents();
        model.addAttribute("students", allStudents);

        return "showStudents";
    }

    @RequestMapping(value = "/findStudent", method = RequestMethod.GET)
    public String findStudent(Model model) {
        LOGGER.debug("is executed");
        model.addAttribute("searchStudent", new SearchStudentDTO());

        return "findStudent";
    }

    @RequestMapping(value = "/findStudent", method = RequestMethod.POST)
    public String findStudentByName(@ModelAttribute SearchStudentDTO searchStudent, Model model) {
        LOGGER.debug("show found student");
        List<Student> foundStudent = studentQueryService.search(searchStudent);
        model.addAttribute("searchStudent", new SearchStudentDTO());
        model.addAttribute("foundStudent", foundStudent);

        return "findStudent";
    }



    @RequestMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        LOGGER.debug("is executed!");
        Student student = studentCommandService.findStudentByID(id);
        String message = String.format("Udało się usunąć kursanta %s %s", student.getFirstName(), student.getLastName());
        studentCommandService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("info", message);

        return "redirect:/";
    }

    @RequestMapping("/student/edit/{id}")
    public String editAccount(@PathVariable("id") Long id, Model model) {
        LOGGER.debug("Edit Account");
        Student student = studentCommandService.findStudentByID(id);
        model.addAttribute("student", student);

        return "studentForm";
    }
}
