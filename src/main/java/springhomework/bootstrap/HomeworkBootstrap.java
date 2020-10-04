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
        Set<Homework> homeworkSet = new HashSet<>();

        Homework homework = new Homework();
        homework.setTask("Przetłumacz poniższe zdanie");
//        homework.setName("Zadanie 1");
        Set<Exercise> exerciseList = makeExercises();
        for(Exercise exercise : exerciseList){
            exercise.setHomework(homework);
            homework.addExercise(exercise);
        }
        homeworkSet.add(homework);
        exerciseRepository.saveAll(exerciseList);

        homework = new Homework();
        homework.setTask("Napisz zdania o przeciwnym znaczeniu");
//        homework.setName("Zadanie 2");

        Set<Exercise> exerciseList2 = makeExercises2();
        for(Exercise exercise : exerciseList2){
            exercise.setHomework(homework);
            homework.addExercise(exercise);
        }
        homeworkSet.add(homework);


        exerciseRepository.saveAll(exerciseList2);
        homeworkRepository.saveAll(homeworkSet);
//        homeworkRepository.save(homework);

}
    private Set<Exercise> makeExercises(){
        Set<Exercise> exercises = new HashSet<>();

        Exercise exercise = new Exercise();
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


        exercise = new Exercise();
        exercise.setContent("Jaki jest jego ulubiony przedmiot?");
        answers = new HashSet<>();
        answer = new Answer();
        answer.setDescription("What's his favourite subject?");
        answer.setExercise(exercise);
        answers.add(answer);
        answer2 = new Answer();
        answer2.setDescription("What's his favourite subject");
        answer2.setExercise(exercise);
        answers.add(answer2);
        answer3 = new Answer();
        answer3.setDescription("What is his favourite subject?");
        answer3.setExercise(exercise);
        answers.add(answer3);
        answer = new Answer();
        answer.setDescription("What is his favourite subject");
        answer.setExercise(exercise);
        answers.add(answer);
        exercise.setAnswers(answers);

        exercises.add(exercise);

        return exercises;
    }
    private Set<Exercise> makeExercises2(){
        Set<Exercise> exercises = new HashSet<>();

        Exercise exercise = new Exercise();
        exercise.setContent("I'm downloading a song.");
        Set<Answer> answers = new HashSet<>();
        Answer answer = new Answer();
        answer.setDescription("I'm not downloading a song.");
        answer.setExercise(exercise);
        answers.add(answer);
        Answer answer2 = new Answer();
        answer2.setDescription("I am not downloading a song.");
        answer2.setExercise(exercise);
        answers.add(answer2);
        Answer answer3 = new Answer();
        answer3.setDescription("I am not downloading a song");
        answer3.setExercise(exercise);
        answers.add(answer3);
        answer = new Answer();
        answer.setDescription("I'm not downloading a song");
        answer.setExercise(exercise);
        answers.add(answer);
        exercise.setAnswers(answers);

        exercises.add(exercise);


        exercise = new Exercise();
        exercise.setContent("They're doing their homework.");
        answers = new HashSet<>();
        answer = new Answer();
        answer.setDescription("They aren't doing their homework.");
        answer.setExercise(exercise);
        answers.add(answer);
        answer2 = new Answer();
        answer2.setDescription("They aren't doing their homework");
        answer2.setExercise(exercise);
        answers.add(answer2);
        answer3 = new Answer();
        answer3.setDescription("They are not doing their homework");
        answer3.setExercise(exercise);
        answers.add(answer3);
        answer = new Answer();
        answer.setDescription("They are not doing their homework.");
        answer.setExercise(exercise);
        answers.add(answer);
        exercise.setAnswers(answers);

        exercises.add(exercise);


        exercise = new Exercise();
        exercise.setContent("We aren't taking a selfie.");
        answers = new HashSet<>();
        answer = new Answer();
        answer.setDescription("We are taking a selfie.");
        answer.setExercise(exercise);
        answers.add(answer);
        answer2 = new Answer();
        answer2.setDescription("We are taking a selfie");
        answer2.setExercise(exercise);
        answers.add(answer2);
        answers.add(answer);
        exercise.setAnswers(answers);

        exercises.add(exercise);

        return exercises;
    }
}