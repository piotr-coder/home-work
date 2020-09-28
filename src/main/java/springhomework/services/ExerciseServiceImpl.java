package springhomework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springhomework.domain.Exercise;
import springhomework.domain.Homework;
import springhomework.repositories.ExerciseRepository;
import springhomework.repositories.HomeworkRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ExerciseServiceImpl implements ExerciseService{
    private final ExerciseRepository exerciseRepository;
    private final HomeworkRepository homeworkRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, HomeworkRepository homeworkRepository) {
        this.exerciseRepository = exerciseRepository;
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public Exercise findById(Long l) {
            Optional<Exercise> exerciseOptional = exerciseRepository.findById(l);
            if(!exerciseOptional.isPresent()){
                throw new RuntimeException("Exercise Not Found!!");
            }
            return exerciseOptional.get();
    }

    @Override
    public Exercise findByHomeworkIdAndExerciseId(Long homeworkId, Long exerciseId) {
        Optional<Homework> homeworkOptional = homeworkRepository.findById(homeworkId);
        if (!homeworkOptional.isPresent()) {
            log.error("Homework id not found. Homework ID: " + homeworkId);
        }
        Homework homework = homeworkOptional.get();

        Optional<Exercise> exerciseOptional = homework.getExercises().stream()
                .filter(exercise -> exercise.getId().equals(exerciseId)).findFirst();
        if (!exerciseOptional.isPresent()) {
            log.error("Exercise id not found. Exercise ID: " + exerciseId);
        }
        return exerciseOptional.get();
    }

    @Override
    public Set<Exercise> getExercises() {
        log.debug("I'm in the ExerciseService");
        Set<Exercise> exerciseSet = new HashSet<>();
        exerciseRepository.findAll().iterator().forEachRemaining(exerciseSet::add);
        return exerciseSet;
    }

    @Override
    public Exercise saveExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
        return exercise;
    }
}