package springhomework.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springhomework.domain.Homework;
import springhomework.repositories.HomeworkRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private String userName;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public void setUserName(String userName) {
        this.userName=userName;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public Set<Homework> getHomeworks() {
        log.debug("I'm in the HomeworkService");
        Set<Homework> homeworkSet = new HashSet<>();
        homeworkRepository.findAll().iterator().forEachRemaining(homeworkSet::add);
        return homeworkSet;
    }

    @Override
    public Homework findById(Long l) {
        Optional<Homework> homeworkOptional = homeworkRepository.findById(l);
        if (!homeworkOptional.isPresent()) {
            throw new RuntimeException("Homework Not Found!!");
        }
        return homeworkOptional.get();
    }

    @Override
    public Homework saveHomework(Homework homework) {
        homeworkRepository.save(homework);
        return homework;
    }
}
