package edu.sdccd.cisc191.springjpa.repository;

import edu.sdccd.cisc191.springjpa.exercises.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, String> {
}
