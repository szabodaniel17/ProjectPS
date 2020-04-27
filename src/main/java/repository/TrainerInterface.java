package repository;

import entity.Exercise;
import entity.FoodItem;

import java.util.List;

/**
 * Intefata folosita pentru a afisa doar metodele clasei TrainerRepository.
 * Folosita pentru implementarea Design Pattern-ului Facade.
 */
public interface TrainerInterface {

    List<FoodItem> getAllFoodItems();
    List<Exercise> getAllExercises();
    String addFoodItems(FoodItem foodItem);
    String addExercises(Exercise exercise);
}
