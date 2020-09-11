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

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Answer> answers = new HashSet<>();

    @ManyToOne
    private Homework homework;
    }
