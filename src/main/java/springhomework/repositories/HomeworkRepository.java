package springhomework.repositories;

import org.springframework.data.repository.CrudRepository;
import springhomework.domain.Homework;

public interface HomeworkRepository extends CrudRepository<Homework, Long> {
}
