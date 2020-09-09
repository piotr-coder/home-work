package springhomework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String task;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "homework")
    private Set<Exercise> exercises = new HashSet<>();

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }
}
