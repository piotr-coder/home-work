package springhomework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = {"homework"})
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String guess;
    private Double rate;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<>();

    @ManyToOne
    private Homework homework;

    public Double setRate() {
        for(Answer answer : answers){
            if (answer.equals(guess)) return 6d;

//        todo need to improve!!;
        }

//        todo implement all other possible solutions;

        return 0d;
    }
}
