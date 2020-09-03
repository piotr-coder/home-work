package springhomework.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Exercise {
    private Long id;

    private String name;
    private String task;
    private String content;
    private Set<String> answers;

}
