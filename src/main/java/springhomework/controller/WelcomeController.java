package springhomework.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springhomework.domain.Answer;
import springhomework.domain.Exercise;
import springhomework.domain.ExerciseService;

import java.util.Iterator;
import java.util.Set;

@Data
@Controller
public class WelcomeController {
    private final ExerciseService exerciseService;


    @GetMapping({"","/", "/index"})
    public String showIndexPage(Model model){
        System.out.println("I'm in showIndexPage()  ");
//        model.addAttribute("exercise", exerciseService.makeAnExercise());
//        model.addAttribute("inputText", new String());
//        exerciseService.setUserName(name);
//        System.out.println("User name was entered by user: " + name);
        return "index";
    }
//    @RequestMapping({"","/", "/index"})
//    public String handleIndexPage(@ModelAttribute String name){
//        System.out.println("I'm in handleIndexPage()");
//        exerciseService.setUserName(name);
//        System.out.println("User name was entered by user: " + name);
//        return "redirect:/welcome";
//    }

    @RequestMapping({"indexx","/indexx"})
    public String handleIndexPage(@RequestParam("inputText") String name){
        System.out.println("I'm in handleIndexPage()");
        exerciseService.setUserName(name);
        System.out.println("User name was entered by user: " + name);
        return "redirect:/welcome";
    }

    @RequestMapping({"welcome", "/welcome"})
    public String showWelcomePage(Model model){
        System.out.println("User name was set by user to: " + exerciseService.getUserName());
        model.addAttribute("exercise", exerciseService.findById(2L));
        Exercise exercise = exerciseService.findById(2L);
        Set<Answer> answers = exercise.getAnswers();
        for (int i = 0; i < exercise.getAnswers().size(); i++) {
            Object o =  exercise.getAnswers().iterator();
            System.out.println(o.toString());
            ((Iterator) o).next();
        }
        System.out.println("*************************\n");
        return "welcome";
    }
}