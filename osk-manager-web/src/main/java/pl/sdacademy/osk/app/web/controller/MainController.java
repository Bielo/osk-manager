package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sdacademy.service.drivinglesson.DrivingLessonQueryService;
import pl.sdacademy.service.drivinglesson.dto.DrivingLessonDTO;
import pl.sdacademy.service.student.StudentCommandService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
}
