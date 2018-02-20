package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sdacademy.service.student.StudentCommandService;

@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final StudentCommandService studentCommandService;

    @Autowired
    public MainController(StudentCommandService studentCommandService) {
        this.studentCommandService = studentCommandService;
    }

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String main() {
        LOGGER.debug("is executed");

        return "adminMain";
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String schedule() {
        LOGGER.debug("is executed");

        return "schedule";
    }

    @RequestMapping(value = "/findStudent", method = RequestMethod.GET)
    public String findStudent() {
        LOGGER.debug("is executed");

        return "findStudent";
    }

    @RequestMapping(value = "/findTeacher", method = RequestMethod.GET)
    public String findTeacher() {
        LOGGER.debug("is executed");

        return "findTeacher";
    }

    @RequestMapping(value = "/showStudents", method = RequestMethod.GET)
    public String showStudents() {
        LOGGER.debug("is executed");

        return "showStudents";
    }

    @RequestMapping(value = "/showTeachers", method = RequestMethod.GET)
    public String showTeachers() {
        LOGGER.debug("is executed");

        return "showTeachers";
    }

    @RequestMapping(value = "/findStudent", method = RequestMethod.POST)
    public String findStudentByFirstOrLastName() {
        return "";
    }
}
