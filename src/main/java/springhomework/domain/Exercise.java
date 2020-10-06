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
        System.out.println("Checking equality (exercise id: " + id + " content: " + content
                + ") of guess: \n" + guess + "\nand the answers:");
        for(Answer answer : answers){
            System.out.println(answer.getDescription());
            if (answer.getDescription().equals(guess)) return 6d;
        }

//        todo implement all other possible solutions;


        return 0d;
    }
}
