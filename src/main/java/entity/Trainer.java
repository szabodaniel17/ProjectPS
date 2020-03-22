package entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "Trainers")
public class Trainer extends User {
    public Trainer(String name, Date dateOfBirth,String phoneNumber){
        super(name,dateOfBirth,phoneNumber);
    }
}
