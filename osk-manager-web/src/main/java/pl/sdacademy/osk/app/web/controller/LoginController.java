package pl.sdacademy.osk.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sdacademy.osk.app.dto.LoginDTO;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute("login") LoginDTO login) {
        ModelAndView model = new ModelAndView();
        model.addObject("login", login);
        model.setViewName("login");

        return model;
    }
}
