package com.example.sd2020.demo;

import entity.FoodItem;
import entity.FoodType;
import org.junit.Test;
import service.FoodItemFactory;

import static org.junit.Assert.assertEquals;

public class FactoryTest {

    @Test
    public void factoryTest(){
        FoodItemFactory factory = new FoodItemFactory();
        FoodItem proteinTest = new FoodItem("Proteic bar", 400, "100g", FoodType.PROTEIN);
        FoodItem fiberTest = new FoodItem("Fiber bar", 250, "100g", FoodType.FIBER);
        FoodItem carbsTest = new FoodItem("Pasta Carbonara", 900, "300g", FoodType.CARBS);

        FoodItem protein = factory.addFoodItem("Proteic bar",400,"PROTEIN","100g");
        FoodItem fiber = factory.addFoodItem("Fiber bar",250,"FIBER","100g");
        FoodItem carbs = factory.addFoodItem("Pasta Carbonara",900,"CARBS","300g");

        assertEquals(proteinTest,protein);
        assertEquals(fiberTest,fiber);
        assertEquals(carbsTest,carbs);

    }
}
