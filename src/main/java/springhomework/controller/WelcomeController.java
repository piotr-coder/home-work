package springhomework.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springhomework.domain.ExerciseService;

@Data
@Controller
public class WelcomeController {
    private final ExerciseService exerciseService;


    @RequestMapping({"","/", "/index"})
    public String showIndexPage(){
        System.out.println("I'm in showIndexPage");
        return "index";
    }
    @RequestMapping({"welcome", "/welcome"})
    public String showWelcomePage(Model model){
        System.out.println("I'm in showWelcomePage()");
        System.out.println("*************************\n");
        System.out.println(exerciseService.makeAnExercise().getName());
        model.addAttribute("exercise", exerciseService.makeAnExercise());
        return "welcome";
    }
}

