package entity;

public class CarbsFoodItem extends FoodItem {
    public CarbsFoodItem(String name,Integer kCal,String quantity){
        super(name,kCal,quantity,FoodType.CARBS);
    }
}
