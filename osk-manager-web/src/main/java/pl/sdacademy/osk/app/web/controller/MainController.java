package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sdacademy.domain.entity.Student;
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

    @RequestMapping(value = "/findTeacher", method = RequestMethod.GET)
    public String findTeacher() {
        LOGGER.debug("is executed");

        return "findTeacher";
    }



}
