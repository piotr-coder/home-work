package springhomework.repositories;

import org.springframework.data.repository.CrudRepository;
import springhomework.domain.Exercise;
/**
 * Created by Piotr on 2020-09-04
 */
public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
