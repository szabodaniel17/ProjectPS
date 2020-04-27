package com.example.sd2020.demo;

import entity.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import repository.LoginInterface;
import repository.TrainerInterface;
import service.FoodItemFactory;
import service.LoginService;
import service.TrainerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TrainerTest {
    @Mock
    TrainerInterface trainerRepo;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private TrainerService trainerService;

    @Before
    public void init(){
        trainerService = new TrainerService(trainerRepo);
    };

    @Test
    public void testGetAllFood(){
        FoodItemFactory factory = new FoodItemFactory();
        FoodItem protein = factory.addFoodItem("Proteic bar",400,"PROTEIN","100g");
        FoodItem fiber = factory.addFoodItem("Fiber bar",250,"FIBER","100g");
        FoodItem carbs = factory.addFoodItem("Pasta Carbonara",900,"CARBS","300g");

        List<FoodItem> expected = new ArrayList<>();
        expected.add(protein);
        expected.add(fiber);
        expected.add(carbs);

        List<FoodItem> actual = new ArrayList<>();

        when(trainerRepo.getAllFoodItems()).thenReturn(expected);

        actual = trainerService.getAllFoodItems();

        assertEquals(actual,expected);

    }

    @Test
    public void testGetAllExercise(){
        Exercise ex = new Exercise("flotari","10-12 reps",4,"2 mins");
        Exercise ex1 = new Exercise("abdomene","10-12 reps",5,"1 min 30sec");
        Exercise ex2 = new Exercise("tractiuni","8-10 reps",3,"1 min");

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(ex);
        exercises.add(ex1);
        exercises.add(ex2);

        when(trainerRepo.getAllExercises()).thenReturn(exercises);
        List<Exercise> actual = new ArrayList<>();
        actual = trainerRepo.getAllExercises();

        assertEquals(exercises,actual);
    }

}
