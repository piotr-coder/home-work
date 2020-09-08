package springhomework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springhomework.domain.Exercise;
import springhomework.repositories.ExerciseRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ExerciseServiceImpl implements ExerciseService{
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
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