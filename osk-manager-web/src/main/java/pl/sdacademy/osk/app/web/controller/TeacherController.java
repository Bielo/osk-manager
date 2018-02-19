package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sdacademy.domain.entity.Student;
import pl.sdacademy.domain.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    private List<Teacher> teacherList = new ArrayList<>();

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String index(Model model) {
        LOGGER.debug("is executed!");
        model.addAttribute("teacherList", teacherList);
        model.addAttribute("teacher", new Teacher());

        return "test";
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String addTeacher(Model model) {
        LOGGER.debug("is executed");
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "teacherForm";
    }

    @RequestMapping(value = {"/saveTeacher"}, method = RequestMethod.POST)
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        LOGGER.debug("is executed");
        teacherList.add(teacher);
        return "redirect:/test";
    }
}
