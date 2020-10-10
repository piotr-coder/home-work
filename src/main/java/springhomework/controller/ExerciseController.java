package springhomework.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springhomework.domain.Exercise;
import springhomework.domain.Homework;
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
        Homework zadania = homeworkService.findById(Long.valueOf(id));
        model.addAttribute("zadania", zadania);
        model.addAttribute("userName", homeworkService.getUserName());
        boolean areExercisesDone = true;    // move to HomeworkServiceImpl ?
        for (Exercise exercise : zadania.getExercises()) {
            if (exercise.getGuess() == null) areExercisesDone = false;
        }
        System.out.println("areExercisesDone is:" + areExercisesDone);
        model.addAttribute("areExercisesDone", areExercisesDone);

        boolean areExercisesRated = true;    // move to HomeworkServiceImpl ?
        for (Exercise exercise : zadania.getExercises()) {
            if (exercise.getRate() == null) {
                areExercisesRated = false;
            }
        }
        model.addAttribute("areExercisesRated", areExercisesRated);


        return "exercise/list";
    }
    @RequestMapping("/homework/{homeworkId}/exercise/{exerciseId}")
    public String showExerciseById(@PathVariable String homeworkId, @PathVariable String exerciseId, Model model){
        model.addAttribute("zadania", homeworkService.findById(Long.valueOf(homeworkId)));
        model.addAttribute("exercise", exerciseService
                .findByHomeworkIdAndExerciseId(Long.valueOf(homeworkId),Long.valueOf(exerciseId)));
        model.addAttribute("userName", homeworkService.getUserName());
        return "exercise/exerciseform";
    }
    @PostMapping("answer")
    public String saveAnswer(@ModelAttribute("exercise") Exercise exercise){
        Exercise newExercise = exerciseService.findById(exercise.getId());
        newExercise.setGuess(exercise.getGuess());
        exerciseService.saveExercise(newExercise);

        return "redirect:/homework/" + newExercise.getHomework().getId() + "/show";
    }
    @RequestMapping("/homework/{homeworkId}/rate")
    public String rateHomework(@PathVariable String homeworkId){
        Double marks = 0d;
        Homework homework = homeworkService.findById(Long.valueOf(homeworkId));
        for (Exercise exercise : homework.getExercises()) {
            Double mark = exercise.checkAnswer();
            marks += mark;
            exercise.setRate(mark);
            exerciseService.saveExercise(exercise);
        }
        homework.setRate(marks/homework.getExercises().size());
        homeworkService.saveHomework(homework);
//        homeworkService.findById(Long.valueOf(homeworkId)).setRate();
        return "redirect:/homework/" + homeworkId + "/show";
    }
}
