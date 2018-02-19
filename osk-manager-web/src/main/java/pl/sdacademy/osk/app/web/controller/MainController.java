package pl.sdacademy.osk.app.web.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = {"/", "/main"}, method=RequestMethod.GET)
    public String main() {
        return "adminMain";
    }
}
