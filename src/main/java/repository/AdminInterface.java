package repository;

import entity.Account;
import entity.Exercise;
import entity.FoodItem;
import entity.User;

import java.util.List;

/**
 * Intefata folosita pentru a afisa doar metodele clasei AdminRepository.
 * Folosita pentru implementarea Design Pattern-ului Facade.
 */
public interface AdminInterface  {

    public static AdminInterface getInstance(){
        return new AdminRepository();
    }
    List<Account> getAllAccounts();
    List<User> getAllUsers();
    String addNewUser(User user, Account account);
    String updateUser(User user, Account account);
    String removeUser(String username);
    String addFoodItems(FoodItem foodItem);
    String updateFoodItems(FoodItem foodItem);
    String addExercises(Exercise exercise);
    String updateExercises(Exercise exercise);
    String removeFoodItems(FoodItem foodItem);
    String removeExercises(Exercise exercise);

}
