package service;

import entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.AdminInterface;
import repository.LoginInterface;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AdminService {
    private AdminInterface adminRepo = AdminInterface.getInstance();
    private List<TrainerManagement> trainerManagement = new ArrayList<>();

    public AdminService(){}
    public AdminService(AdminInterface adminRepo){ this.adminRepo = adminRepo;}


    @GetMapping("/getAllAccounts")
    @CrossOrigin(origins = "*")
    public List<Account> getAllAccounts(){
        ArrayList<Account> accounts = new ArrayList<>();
        accounts = (ArrayList<Account>) adminRepo.getAllAccounts();
        if(accounts == null){
            System.out.println("No accounts in the database");
        }
        return accounts;
    }

    @GetMapping("/getAllUsers")
    @CrossOrigin(origins = "*")
    public List<User> getAllUsers(){
        ArrayList<User> accounts = new ArrayList<>();
        accounts = (ArrayList<User>) adminRepo.getAllUsers();
        if(accounts == null){
            System.out.println("No accounts in the database");
        }
        return accounts;
    }

    @PostMapping("/addNewUser")
    @CrossOrigin(origins = "*")
    public String addNewUser(String name,String date,String phoneNumber, String username,String password){
        Account account = new Account(username,password);
        User user ;
        Date dob_d = new Date();
        try {
            dob_d = new SimpleDateFormat("dd/MM/yyyy").parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(username.contains("admin")){
            user = new Admin(name,dob_d,phoneNumber,account);
        }else{
            user = new Trainer(name,dob_d,phoneNumber,account);
        }
        String result;
        result = adminRepo.addNewUser(user,account);
        return result;
    }

    @PostMapping("/updateUser")
    @CrossOrigin(origins = "*")
    public String updateUser(String name,String date,String phoneNumber, String username,String password){
        Account account = new Account(username,password);
        User user ;
        Date dob_d = new Date();
        try {
            dob_d = new SimpleDateFormat("dd/MM/yyyy").parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(username.contains("admin")){
            user = new Admin(name,dob_d,phoneNumber,account);
        }else{
            user = new Trainer(name,dob_d,phoneNumber,account);
        }
        String result;
        result = adminRepo.updateUser(user,account);
        return result;
    }

    @PostMapping("/removeUser")
    @CrossOrigin(origins = "*")
    public String removeUser(String username){
        String result;
        result = adminRepo.removeUser(username);
        return result;
    }

    @PostMapping("/addFoodItems")
    @CrossOrigin(origins = "*")
    public String addFoodItems(String name,Integer kCal,String quantity,String type){
        FoodItem foodItem = new FoodItem();
        if(type == "PROTEIN"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.PROTEIN);
        }else if(type == "FIBER"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.FIBER);
        }else if(type== "CARBS"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.CARBS);
        }
        String result;
        result = adminRepo.addFoodItems(foodItem);
        return result;
    }

    @PostMapping("/addExercises")
    @CrossOrigin(origins = "*")
    public String addExercises(String name,String reps,Integer sets,String restTime){
        Exercise exercise = new Exercise(name,reps,sets,restTime);
        String result;
        result = adminRepo.addExercises(exercise);
        this.setExercise(exercise);
        return result;
    }

    @PostMapping("/removeFoodItems")
    @CrossOrigin(origins = "*")
    public String removeFoodItems(String name,Integer kCal,String quantity,String type){
        FoodItem foodItem = new FoodItem();
        if(type == "PROTEIN"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.PROTEIN);
        }else if(type == "FIBER"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.FIBER);
        }else if(type== "CARBS"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.CARBS);
        }
        String result;
        result = adminRepo.removeFoodItems(foodItem);
        return result;
    }

    @PostMapping("/updateFoodItem")
    @CrossOrigin(origins = "*")
    public String updateFoodItem(String name,Integer kCal,String quantity,String type){
        FoodItem foodItem = new FoodItem();
        if(type == "PROTEIN"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.PROTEIN);
        }else if(type == "FIBER"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.FIBER);
        }else if(type== "CARBS"){
            foodItem = new FoodItem(name,kCal,quantity, FoodType.CARBS);
        }
        String result;
        result = adminRepo.updateFoodItems(foodItem);
        return result;
    }

    @PostMapping("/updateExercise")
    @CrossOrigin(origins = "*")
    public String updateExercise(String name,String reps,Integer sets,String restTime){
        Exercise exercise = new Exercise(name,reps,sets,restTime);
        String result;
        result = adminRepo.updateExercises(exercise);
        return result;
    }

    @PostMapping("/removeExercises")
    @CrossOrigin(origins = "*")
    public String removeExercises(String name,String reps,Integer sets,String restTime){
        Exercise exercise = new Exercise(name,reps,sets,restTime);
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
