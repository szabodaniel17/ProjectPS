package service;

import entity.Exercise;
import entity.FoodItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import repository.TrainerInterface;


import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainerService implements TrainerManagement{

    private TrainerInterface trainerRepo;
    private Exercise exercise;
    private List<Exercise> exercises;
    private List<FoodItem> foodItems;

    public TrainerService(){
        this.exercises = new ArrayList<>();
        this.foodItems = new ArrayList<>();
    }
    public TrainerService(TrainerInterface trainerInterface){
        this.trainerRepo = trainerInterface;
        this.exercises = new ArrayList<>();
        this.foodItems = new ArrayList<>();
    }

    /**
     * Avem entry point pentru adaugarea unui FoodItem in baza de date.
     *
     * @param foodItem
     * @return
     */

    @GetMapping("/addFoodItem")
    public String addFoodItems(FoodItem foodItem){
        String result;
        result = trainerRepo.addFoodItems(foodItem);
        return result;
    }


    /**
     * Entry point pentru adaugarea unui exercitiu in baza de date
     *
     * @param exercise
     * @return
     */
    @GetMapping("/addExercises")
    public String addExercises(Exercise exercise){
        String result;
        result = trainerRepo.addExercises(exercise);
        return result;
    }


    /**
     * Datele extrase din baza de date, alimentele precum si exercitiile vor fi stocate in cate o lista,
     * din care ulterior, vom putea selecta alimente pentru o dieta precum si exercitii pentru un plan de antrenament.
     */

    @GetMapping("/getAllFoodItems")
    public List<FoodItem> getAllFoodItems(){
        this.foodItems = trainerRepo.getAllFoodItems();

        return this.foodItems;
    }

    @GetMapping("/getAllExercises")
    public List<Exercise> getAllExercises(){
        this.exercises = trainerRepo.getAllExercises();

        return this.exercises;
    }

    /**
     * Metodele de mai jos sunt folosite la realizarea Design Pattern-ului Observer.
     *
     * @param exercise
     */
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
