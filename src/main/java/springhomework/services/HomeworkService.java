package springhomework.services;

import springhomework.domain.Homework;

import java.util.Set;

public interface HomeworkService {
    void setUserName(String userName);
    String getUserName();
    Set<Homework> getHomeworks();
    Homework findById(Long l);
    Homework saveHomework(Homework homework);
}
