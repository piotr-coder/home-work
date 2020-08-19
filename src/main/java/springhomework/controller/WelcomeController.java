package springhomework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping({"","/", "/index"})
    public String showWelcomePage(){
        System.out.println("I'm in " + WelcomeController.class.toString());
        return "welcome";
    }
}
