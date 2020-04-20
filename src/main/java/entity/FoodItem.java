package entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


/**
 * Aceasta clasa este folosita pentru a crea obiecte de tip
 * FoodItem, adica alimente. Pentru ele vom avea un ID unic,
 * o valoare calorica per 100g stocata ca Integer si o cantitate
 * stocata ca String, deoarece putem avea diferite masuri fizice, cum ar fi
 * grame, mililitrii, sau masuri simbolice precum lingurita, lingura, cana etc.
 * */
@Entity
public class FoodItem {

    @Id
    private final String id;
    @Column
    private String name;
    private Integer kCal;
    private String quantity;
    private FoodType type;

    FoodItem(){
        id = UUID.randomUUID().toString();
    }

    public FoodItem(String name,Integer kCal,String quantity,FoodType type){
        this.name = name;
        this.kCal = kCal;
        id = UUID.randomUUID().toString();
        this.quantity = quantity;
        this.type = type;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return
                //Objects.equals(id, foodItem.id) &&
                Objects.equals(name, foodItem.name) &&
                Objects.equals(quantity, foodItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getkCal() {
        return kCal;
    }

    public void setkCal(int kCal) {
        this.kCal = kCal;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", kCal=" + kCal +
                ", quantity='" + quantity + '\'' +
                ", type=" + type +
                '}';
    }
}
