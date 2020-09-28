package springhomework.services;

import springhomework.domain.Exercise;

import java.util.Set;

public interface ExerciseService {
    Set<Exercise> getExercises();
    Exercise findById(Long l);
    Exercise findByHomeworkIdAndExerciseId(Long homeworkId, Long exerciseId);
    Exercise saveExercise(Exercise exercise);
}
