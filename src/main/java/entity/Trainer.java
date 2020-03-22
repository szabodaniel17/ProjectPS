package entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "Trainers")
public class Trainer extends User {

    public Trainer(){};

    public Trainer(String name, Date dateOfBirth,String phoneNumber,Account account){
        super(name,dateOfBirth,phoneNumber,account);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
