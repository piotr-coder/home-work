package springhomework.services;

import springhomework.domain.Exercise;

import java.util.Set;

public interface ExerciseService {
    Set<Exercise> getExercises();
    Exercise findById(Long l);
    Exercise saveExercise(Exercise exercise);
}
