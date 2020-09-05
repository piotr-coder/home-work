package springhomework.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springhomework.repositories.ExerciseRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class ExerciseServiceImpl implements ExerciseService{
    private final ExerciseRepository exerciseRepository;
    private String userName;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


    @Override
    public String getUserName() {
        return userName;
    }
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Exercise findById(Long l) {
            Optional<Exercise> exerciseOptional = exerciseRepository.findById(l);
            if(!exerciseOptional.isPresent()){
                throw new RuntimeException("Recipe Not Found!!");
            }
            return exerciseOptional.get();
    }

    @Override
    public Set<Exercise> getExercises() {
        log.debug("I'm in the service");
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
