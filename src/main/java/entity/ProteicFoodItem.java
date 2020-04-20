package entity;

public class ProteicFoodItem extends FoodItem {
    public ProteicFoodItem(String name,Integer kCal,String quantity){
        super(name,kCal,quantity,FoodType.PROTEIN);
    }
}
