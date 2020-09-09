package springhomework.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        homeworkService.findById(1l).setName(userName);
        log.info("I'm in handleIndexPage(): User entered name: " + userName);
        return "redirect:/welcome";
    }

    @RequestMapping({"welcome", "/welcome"})
    public String showWelcomePage(Model model){
        System.out.println("User name was set by user to: " + homeworkService.getUserName());
        model.addAttribute("homeworks", homeworkService.getHomeworks());
        model.addAttribute("name", homeworkService.getUserName());

        return "welcome";
    }
    @RequestMapping({"list","/list"})
    public String getIndexPage(Model model){
//        log.debug("RequestMapping was invoked");
        model.addAttribute("zadania", exerciseService.getExercises());
        return "list";
    }
}