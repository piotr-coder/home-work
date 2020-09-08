package springhomework.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springhomework.domain.Answer;
import springhomework.domain.Exercise;
import springhomework.services.ExerciseService;
import springhomework.services.HomeworkService;

import java.util.Iterator;
import java.util.Set;

@Slf4j
@Data
@Controller
public class WelcomeController {
    private final ExerciseService exerciseService;
    private final HomeworkService homeworkService;


    @GetMapping({"","/", "/index"})
    public String showIndexPage(Model model){
        log.info("I'm in showIndexPage()");
        return "index";
    }

    @PostMapping({"index","/index"})
    public String handleIndexPage(@RequestParam String userName){
        homeworkService.setUserName(userName);
        log.info("I'm in handleIndexPage(): User entered name: " + userName);
        return "redirect:/welcome";
    }

    @RequestMapping({"welcome", "/welcome"})
    public String showWelcomePage(Model model){
        System.out.println("User name was set by user to: " + homeworkService.getUserName());
        model.addAttribute("exercise", exerciseService.findById(2L));
        Exercise exercise = exerciseService.findById(2L);
        Set<Answer> answers = exercise.getAnswers();
        for (Iterator<Answer> iterator = answers.iterator(); iterator.hasNext(); ) {
            Answer next =  iterator.next();
            System.out.println(next.getDescription());
        }
        System.out.println("*************************\n");
        return "welcome";
    }
}