package edu.sdccd.cisc191.springjpa.repository;

import edu.sdccd.cisc191.springjpa.exercises.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, String> {
    List<Exercise> findByUpperBodyPart(String upperBodyPart);
}
