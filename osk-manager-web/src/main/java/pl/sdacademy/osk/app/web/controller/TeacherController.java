package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.service.teacher.TeacherCommandService;

import java.util.List;

@Controller
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final TeacherCommandService teacherCommandService;

    @Autowired
    public TeacherController(TeacherCommandService teacherCommandService) {
        this.teacherCommandService = teacherCommandService;
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String addTeacher(Model model) {
        LOGGER.debug("add teacher is executed");
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "teacherForm";
    }

    @RequestMapping(value = {"/saveTeacher"}, method = RequestMethod.POST)
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, Model model){
        LOGGER.debug("save teacher is executed");
        int sizeBefore = teacherCommandService.teacherCount();
        teacherCommandService.create(teacher);
        int afterSize = teacherCommandService.teacherCount();
        if(sizeBefore == afterSize){
            model.addAttribute("info", "Nie udało się dodać instruktora");
        } else {
            model.addAttribute("info", "Udało sie dodać instruktora!");
        }
        return "adminMain";
    }

    @RequestMapping(value = {"/showTeachers"})
    public String showAllTeachers(Model model) {
        LOGGER.debug("show all teachers is executed");
        List<Teacher> allTeachers = teacherCommandService.findAllTeachers();

        model.addAttribute("teachers", allTeachers);

        return "showTeachers";
    }

}
