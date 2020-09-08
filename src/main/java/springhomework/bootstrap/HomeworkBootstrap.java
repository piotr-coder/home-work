package springhomework.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springhomework.domain.Answer;
import springhomework.domain.Exercise;
import springhomework.domain.Homework;
import springhomework.repositories.ExerciseRepository;
import springhomework.repositories.HomeworkRepository;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class HomeworkBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final ExerciseRepository exerciseRepository;
    private final HomeworkRepository homeworkRepository;

    public HomeworkBootstrap(ExerciseRepository exerciseRepository,
                             HomeworkRepository homeworkRepository) {
        this.exerciseRepository = exerciseRepository;
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("onApplicationEvent was invoked");
        Homework homework = new Homework();
        homework.setTask("Przetłumacz poniższe zdanie");
        Set<Exercise> exerciseList = makeExercises();
        homework.setExercises(exerciseList);
        exerciseRepository.saveAll(makeExercises());
//        homeworkRepository.save(homework);

}
    private Set<Exercise> makeExercises(){
        Set<Exercise> exercises = new HashSet<>(2);

        Exercise exercise = new Exercise();
        exercise.setId(1l);
        exercise.setContent("Jem jabłko");
        Set<Answer> answers = new HashSet<>();
        Answer answer = new Answer();
        answer.setDescription("I'm eating an apple");
        answer.setExercise(exercise);
        answers.add(answer);
        Answer answer2 = new Answer();
        answer2.setDescription("I'm eating an apple.");
        answer2.setExercise(exercise);
        answers.add(answer2);
        Answer answer3 = new Answer();
        answer3.setDescription("I am eating an apple");
        answer3.setExercise(exercise);
        answers.add(answer3);
        answer = new Answer();
        answer.setDescription("I am eating an apple.");
        answer.setExercise(exercise);
        answers.add(answer);
        exercise.setAnswers(answers);

        exercises.add(exercise);


        exercise = new Exercise();
        exercise.setId(2l);
        exercise.setContent("Ja mam telefon komórkowy");
        answers = new HashSet<>();
        answer = new Answer();
        answer.setDescription("I have a mobile phone");
        answer.setExercise(exercise);
        answers.add(answer);
        answer2 = new Answer();
        answer2.setDescription("I've got a mobile phone");
        answer2.setExercise(exercise);
        answers.add(answer2);
        answer3 = new Answer();
        answer3.setDescription("I have got a mobile phone");
        answer3.setExercise(exercise);
        answers.add(answer3);
        answer = new Answer();
        answer.setDescription("I have a mobile phone.");
        answer.setExercise(exercise);
        answers.add(answer);
        exercise.setAnswers(answers);

        exercises.add(exercise);
        return exercises;
    }
}