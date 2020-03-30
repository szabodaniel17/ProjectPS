package service;

import entity.Account;
import entity.Exercise;
import entity.Trainer;
import entity.User;
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
    private Exercise exercise;

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
    public String addFoodItems(){
        return "Success";
    }

    @GetMapping("/addExercises")
    public String addExercises(){
        return "Success";
    }

    @GetMapping("/removeFoodItems")
    public String removeFoodItems(){
        return "Success";
    }

    @GetMapping("/removeExercises")
    public String removeExercises(){
        return "Success";
    }

    public void addObserver(TrainerManagement trainerManagement) {
        this.trainerManagement.add(trainerManagement);
    }

    public void removeObserver(TrainerManagement channel) {
        this.trainerManagement.remove(channel);
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
        for (TrainerManagement trainerManagement : this.trainerManagement) {
            trainerManagement.update(this.exercise);
        }
    }
}
