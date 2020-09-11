package springhomework.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springhomework.domain.Homework;
import springhomework.services.ExerciseService;
import springhomework.services.HomeworkService;

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

        // for tests only
        Homework zadanie = homeworkService.findById(1l);
        zadanie.setName(userName);
        homeworkService.saveHomework(zadanie);
        // for tests only

        log.info("I'm in handleIndexPage(): User entered name: " + userName);
        return "redirect:/welcome";
    }
    @RequestMapping({"welcome", "/welcome"})
    public String showWelcomePage(Model model){
        System.out.println("User name was set by user to: " + homeworkService.getUserName());
        model.addAttribute("homeworks", homeworkService.getHomeworks());
        model.addAttribute("name", homeworkService.getUserName());

        return "listHomeworks";
    }
}