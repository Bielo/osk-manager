package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sdacademy.domain.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
    private List<Student> studentList = new ArrayList<>();

    @RequestMapping(value = {"/addStudent"}, method = RequestMethod.GET)
    public String addStudent(Model model) {
        LOGGER.debug("is executed");
        Student student = new Student();
        model.addAttribute("student", student);

        return "studentForm";
    }

    @RequestMapping(value = {"/saveStudent"}, method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student){
        LOGGER.debug("is executed");
        studentList.add(student);
        return "redirect:/test";
    }
}
