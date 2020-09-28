package springhomework.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Homework implements Comparable<Homework> {
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

    @Override
    public int compareTo(Homework o) {
        if(o.id > this.id) return 1;
        return 0;
    }

    //    @Override
//    public int compare(Homework o1, Homework o2) {
//        return (int)(o1.id - o2.id);
//    }
}
