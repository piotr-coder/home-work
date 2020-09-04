package springhomework.domain;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("I'm on my way...");

        Set<Answer> odpowiedzi = makeAnExercise().getAnswers();
        for (Answer answer : odpowiedzi) {
            System.out.println(answer.getDescription());
        }
    }
    private static Exercise makeAnExercise(){
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
