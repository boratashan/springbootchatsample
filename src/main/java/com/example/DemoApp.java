package com.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class DemoApp {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String login(Model model) {
        model.addAttribute("uname", "test");
        return "login";
    }
}
