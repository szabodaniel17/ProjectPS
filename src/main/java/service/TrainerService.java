package service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Exercise;
import entity.FoodItem;
import entity.FoodType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.TrainerInterface;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainerService implements TrainerManagement{

    private TrainerInterface trainerRepo = TrainerInterface.getInstance();
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
     * @param
     * @return
     */

    @PostMapping("/addFoodItem")
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
        result = trainerRepo.addFoodItems(foodItem);
        return result;
    }


    /**
     * Entry point pentru adaugarea unui exercitiu in baza de date
     *
     *
     * @return
     */
    @PostMapping("/addTrainerExercises")
    @CrossOrigin(origins = "*")
    public String addExercises(String name,String reps,Integer sets,String restTime){
        Exercise exercise = new Exercise(name,reps,sets,restTime);
        String result;
        result = trainerRepo.addExercises(exercise);
        return result;
    }


    /**
     * Datele extrase din baza de date, alimentele precum si exercitiile vor fi stocate in cate o lista,
     * din care ulterior, vom putea selecta alimente pentru o dieta precum si exercitii pentru un plan de antrenament.
     */

    @GetMapping("/getAllFoodItems")
    @CrossOrigin(origins = "*")
    public List<FoodItem> getAllFoodItems(){
        this.foodItems = trainerRepo.getAllFoodItems();

        return this.foodItems;
    }

    @GetMapping("/getAllExercises")
    @CrossOrigin(origins = "*")
    public List<Exercise> getAllExercises(){
        this.exercises = trainerRepo.getAllExercises();

        return this.exercises;
    }

    @GetMapping("/generateFoodReport")
    @CrossOrigin(origins = "*")
    public String generateFoodReport() throws FileNotFoundException, DocumentException {
        String result = "succes";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("FoodReport.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Diet plan", font);
        document.add(chunk);

        for(FoodItem f:foodItems){
            Paragraph p = new Paragraph(f.toString());
            document.add(p);
        }

        document.close();

        if(document == null){
            return "Fail";
        }
        return result;
    }

    @GetMapping("/generateExerciseReport")
    @CrossOrigin(origins = "*")
    public String generateExerciseReport() throws FileNotFoundException, DocumentException {
        String result = "succes";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("ExerciseReport.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Exercise plan", font);
        document.add(chunk);

        for(Exercise f: exercises){
            Paragraph p = new Paragraph(f.toString());
            document.add(p);
        }

        document.close();

        if(document == null){
            return "Fail";
        }
        return result;
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
