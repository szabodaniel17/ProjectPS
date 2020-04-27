package service;

import entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import repository.AdminInterface;
import repository.LoginInterface;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminService {
    private AdminInterface adminRepo;
    private List<TrainerManagement> trainerManagement = new ArrayList<>();

    public AdminService(){}
    public AdminService(AdminInterface adminRepo){ this.adminRepo = adminRepo;}


    @GetMapping("/getAllUsers")
    public List<Account> getAllUsers(){
        ArrayList<Account> accounts = new ArrayList<>();
        accounts = (ArrayList<Account>) adminRepo.getAllAccounts();
        if(accounts == null){
            System.out.println("No accounts in the database");
        }
        return accounts;
    }

    @GetMapping("/addNewUser")
    public String addNewUser(User user, Account account){
        String result;
        result = adminRepo.addNewUser(user,account);
        return result;
    }

    @GetMapping("/updateUser")
    public String updateUser(User user, Account account){
        String result;
        result = adminRepo.updateUser(user,account);
        return result;
    }

    @GetMapping("/removeUser")
    public String removeUser(String username){
        String result;
        result = adminRepo.removeUser(username);
        return result;
    }

    @GetMapping("/addFoodItems")
    public String addFoodItems(FoodItem foodItem){
        String result;
        result = adminRepo.addFoodItems(foodItem);
        return result;
    }

    @GetMapping("/addExercises")
    public String addExercises(Exercise exercise){
        String result;
        result = adminRepo.addExercises(exercise);
        this.setExercise(exercise);
        return result;
    }

    @GetMapping("/removeFoodItems")
    public String removeFoodItems(FoodItem foodItem){
        String result;
        result = adminRepo.removeFoodItems(foodItem);
        return result;
    }

    @GetMapping("/updateFoodItem")
    public String updateFoodItem(FoodItem foodItem){
        String result;
        result = adminRepo.updateFoodItems(foodItem);
        return result;
    }

    @GetMapping("/updateExercise")
    public String updateExercise(Exercise exercise){
        String result;
        result = adminRepo.updateExercises(exercise);
        return result;
    }

    @GetMapping("/removeExercises")
    public String removeExercises(Exercise exercise){
        String result;
        result = adminRepo.removeExercises(exercise);
        return result;
    }

    public void addObserver(TrainerManagement trainerManagement) {
        this.trainerManagement.add(trainerManagement);
    }

    public void removeObserver(TrainerManagement channel) {
        this.trainerManagement.remove(channel);
    }

    public void setExercise(Exercise exercise) {
        for (TrainerManagement trainerManagement : this.trainerManagement) {
            trainerManagement.update(exercise);
        }
    }
}
