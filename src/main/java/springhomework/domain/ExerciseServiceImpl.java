package springhomework.domain;

import org.springframework.stereotype.Service;
import springhomework.repositories.ExerciseRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExerciseServiceImpl implements ExerciseService{
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


    @Override
    public Exercise makeAnExercise(){
//        Homework homework = new Homework();
        Exercise exercise = new Exercise();
        exercise.setId(1l);
        exercise.setName("Zadanie 1");
        exercise.setTask("Przetłumacz poniższe zdanie");
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


        return exercise;
    }
}
