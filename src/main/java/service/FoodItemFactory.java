package service;

import entity.*;

/**
 * In aceasta clasa am implementat Factory Design Pattern, care va fi folosita
 * in momentul in care un trainer va dori sa creeze un plan alimentar pe baza tipului
 * de aliment. Astfel, vom dori sa avem un plan alimentar  care sa cuprinda alimente
 * de toate tipurile.
 *
 */
public class FoodItemFactory {
    public FoodItem addFoodItem(String name,int kCal, String foodItemType,String quantity){
        FoodItem foodItem = null;
        FoodType type = FoodType.valueOf(foodItemType);
        if(type != null){
            switch (type){
                case PROTEIN:
                    foodItem = new ProteicFoodItem(name,kCal,quantity);
                    break;

                case CARBS:
                    foodItem = new CarbsFoodItem(name,kCal,quantity);
                    break;

                case FIBER:
                    foodItem = new FiberFoodItem(name,kCal,quantity);
                    break;

                default:
                    System.err.println("Unsupported food item type");
            }
        }else{
            System.err.println("Unexistent food item type");
        }

        return foodItem;
    }
}
