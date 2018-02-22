package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.sdacademy.domain.entity.Teacher;
import pl.sdacademy.service.teacher.TeacherCommandService;
import pl.sdacademy.service.teacher.TeacherQueryService;
import pl.sdacademy.service.teacher.dto.SearchTeacherDTO;

import java.util.List;

@Controller
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final TeacherCommandService teacherCommandService;
    private final TeacherQueryService teacherQueryService;

    @Autowired
    public TeacherController(TeacherCommandService teacherCommandService, TeacherQueryService teacherQueryService) {
        this.teacherCommandService = teacherCommandService;
        this.teacherQueryService = teacherQueryService;
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
        if(teacher.getId() == null){
            int sizeBefore = teacherQueryService.teacherCount();
            teacherCommandService.create(teacher);
            int afterSize = teacherQueryService.teacherCount();
            if(sizeBefore == afterSize){
                model.addAttribute("info", "Nie udało się dodać instruktora");
            } else {
                model.addAttribute("info", "Udało sie dodać instruktora!");
            }
        } else {
            teacherCommandService.update(teacher);
            String message = String.format("Udało się pomyślnie zaktualizować dane wybranego instruktora.");
            model.addAttribute("info", message);
        }

        return "adminMain";
    }

    @RequestMapping(value = {"/showTeacherss"})
    public String showAllTeachers(Model model) {
        LOGGER.debug("show all teachers is executed");
        List<Teacher> allTeachers = teacherQueryService.findAllTeachers();
        model.addAttribute("teachers", allTeachers);

        return "showTeachers";
    }

    @RequestMapping(value = "/findTeacher", method = RequestMethod.GET)
    public String findTeacher(Model model) {
        LOGGER.debug("find teacher is executed!");
        model.addAttribute("searchTeacher", new SearchTeacherDTO());

        return "findTeacher";
    }

    @RequestMapping(value = "/findTeacher", method = RequestMethod.POST)
    public String findTeacherByName(@ModelAttribute SearchTeacherDTO searchTeacher, Model model) {
        LOGGER.debug("show found teacher is executed!");
        List<Teacher> foundTeacher = teacherQueryService.search(searchTeacher);
        model.addAttribute("searchTeacher", new SearchTeacherDTO());
        model.addAttribute("foundTeacher", foundTeacher);

        return "foundTeacher";
    }


    @RequestMapping(value = {"/teacher/delete/{id}"})
    public String deleteTeacher(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        LOGGER.debug("delete teacher is executed!");
        Teacher teacher = teacherQueryService.findTeacherByID(id);
        String message = String.format("Udało się usunąć instruktora %s %s", teacher.getFirstName(), teacher.getLastName());
        teacherCommandService.deleteTeacher(id);
        redirectAttributes.addFlashAttribute("info", message);

        return "redirect:/";
    }

    @RequestMapping(value = {"/teacher/edit/{id}"})
    public String editTeacher(@PathVariable("id") Long id, Model model){
        LOGGER.debug("edit teacher is executed!");
        Teacher teacher = teacherQueryService.findTeacherByID(id);
        model.addAttribute("teacher", teacher);

        return "teacherForm";
    }
}
