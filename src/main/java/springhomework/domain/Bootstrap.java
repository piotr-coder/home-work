package springhomework.domain;

import java.util.HashSet;
import java.util.Set;

public class Bootstrap {
    public static Exercise makeAnExercise(){
        Homework homework = new Homework();
        Exercise exercise = new Exercise();
        exercise.setId(1l);
        exercise.setName("Zadanie 1");
        exercise.setTask("Przetłumacz poniższe zdanie");
        exercise.setContent("Jem jabłko");
        Set<String> answers = new HashSet<>();
        answers.add("I'm eating an apple");
        answers.add("I'm eating an apple.");
        answers.add("I am eating an apple");
        answers.add("I am eating an apple.");
        exercise.setAnswers(answers);


        return exercise;
    }
}
