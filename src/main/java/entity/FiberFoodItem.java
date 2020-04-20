package entity;

public class FiberFoodItem extends FoodItem {
    public FiberFoodItem(String name,Integer kCal,String quantity){
        super(name,kCal,quantity,FoodType.FIBER);
    }
}
