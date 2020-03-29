package repository;

import entity.Account;
import entity.User;

import java.util.List;

/**
 * Intefata folosita pentru a afisa doar metodele clasei AdminRepository.
 * Folosita pentru implementarea Design Pattern-ului Facade.
 */
public interface AdminInterface  {

    List<Account> getAllAccounts();
    String addNewUser(User user, Account account);
    String updateUser(User user, Account account);
    String removeUser(String username);
    String addFoodItems();
    String addExercises();
    String removeFoodItems();
    String removeExercises();

}
