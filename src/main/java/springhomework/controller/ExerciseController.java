package springhomework.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springhomework.services.ExerciseService;
import springhomework.services.HomeworkService;

@Data
@Slf4j
@Controller
public class ExerciseController {
    private final ExerciseService exerciseService;
    private final HomeworkService homeworkService;

    @RequestMapping("/homework/{id}/show")
    public String showHomeworkById(@PathVariable String id, Model model){
        model.addAttribute("zadania", homeworkService.findById(Long.valueOf(id)));
        return "/exercise/list";
    }
    @RequestMapping("/homework/{homeworkId}/exercise/{exerciseId}")
    public String showExerciseById(@PathVariable String homeworkId, @PathVariable String exerciseId, Model model){
        model.addAttribute("zadania", homeworkService.findById(Long.valueOf(homeworkId)));
        model.addAttribute("exercise", exerciseService
                .findByHomeworkIdAndExerciseId(Long.valueOf(homeworkId),Long.valueOf(exerciseId)));
        return "/exercise/exerciseform";
    }
}
