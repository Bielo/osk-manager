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

@Controller
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        LOGGER.debug("is executed");
        return "test";
    }

    @RequestMapping(value = {"/addStudent"}, method = RequestMethod.GET)
    public String studentTest(Model model) {
        LOGGER.debug("is executed");
        Student student = new Student();
        model.addAttribute("student", student);

        return "studentForm";
    }

    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String teacherTest(Model model) {
        LOGGER.debug("is executed");
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);

        return "teacherForm";
    }

    @RequestMapping(value = {"/saveStudent"}, method = RequestMethod.POST)
    public String saveStudentTest(@ModelAttribute("student") Student student){
        LOGGER.debug("is executed");

        return "redirect:/test";
    }

    @RequestMapping(value = {"/saveTeacher"}, method = RequestMethod.POST)
    public String saveTeacherTest(@ModelAttribute("teacher") Teacher teacher){
        LOGGER.debug("is executed");

        return "redirect:/test";
    }
}
