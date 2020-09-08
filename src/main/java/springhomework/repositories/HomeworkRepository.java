package springhomework.repositories;

import org.springframework.data.repository.CrudRepository;
import springhomework.domain.Homework;

/**
 * Created by Piotr on 2020-09-05
 */
public interface HomeworkRepository extends CrudRepository<Homework, Long> {
}
