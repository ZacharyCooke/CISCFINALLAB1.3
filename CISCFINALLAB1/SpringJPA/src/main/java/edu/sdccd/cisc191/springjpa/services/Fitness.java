package edu.sdccd.cisc191.springjpa.services;

import edu.sdccd.cisc191.springjpa.exercises.Exercise;
import edu.sdccd.cisc191.springjpa.exercises.Option;
import edu.sdccd.cisc191.springjpa.repository.ExerciseRepository;
import edu.sdccd.cisc191.springjpa.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Fitness {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    OptionRepository optionRepository;

    public List<Exercise> findAll() {return (List<Exercise>) exerciseRepository.findAll();}

    public Option save(Option option) {
        return optionRepository.save(option);
    }

    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }
}
