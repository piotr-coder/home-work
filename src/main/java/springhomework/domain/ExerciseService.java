package springhomework.domain;

import java.util.Set;

public interface ExerciseService {
    void setUserName(String userName);
    String getUserName();
    Set<Exercise> getExercises();
    Exercise findById(Long l);
    Exercise saveExercise(Exercise exercise);
}
