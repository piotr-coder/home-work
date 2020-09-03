package springhomework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping({"","/", "/index"})
    public String showIndexPage(){
        System.out.println("I'm in showIndexPage");
        return "index";
    }
    @RequestMapping({"welcome", "/welcome"})
    public String showWelcomePage(){
        System.out.println("I'm in showWelcomePage()");
        return "welcome";
    }
}
