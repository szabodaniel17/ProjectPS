package service;

import entity.Exercise;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import repository.TrainerInterface;


import java.util.List;

@Controller
public class TrainerService implements TrainerManagement{

    private TrainerInterface trainerRepo;
    private Exercise exercise;

    @GetMapping("/addFoodItem")
    public String addFoodItem(){
        return "Success";
    }

    @GetMapping("/addExercise")
    public String addExercise(){
        return "Success";
    }

    @Override
    public void update(Object exercise) {
        this.setExercise((Exercise)exercise);
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
