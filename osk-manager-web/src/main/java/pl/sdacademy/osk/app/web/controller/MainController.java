package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.student.StudentCommandService;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final StudentCommandService studentCommandService;
    private final DrivingLessonQueryService drivingLessonQueryService;


    @Autowired
    public MainController(StudentCommandService studentCommandService, DrivingLessonQueryService drivingLessonQueryService) {
        this.studentCommandService = studentCommandService;
        this.drivingLessonQueryService = drivingLessonQueryService;
    }

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String main(HttpServletRequest servletRequest) {
        LOGGER.debug("is executed");

        if (servletRequest.isUserInRole("STUDENT")) {
            return "/studentview/studentMain";
        } else if (servletRequest.isUserInRole("TEACHER")) {
            return "/teacherview/teacherMain";
        } else {
            return "/adminview/adminMain";
        }

    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView error(@RequestParam(required = false) String error) {
        LOGGER.error("Error occurred: " + error);

        ModelAndView model = new ModelAndView();
        if (error.equals("forbidden")) {
            model.addObject("error", "Nie masz uprawnień do wyświetlenia tej strony");
        }
        model.setViewName("errorPage");
        return model;
    }
}
