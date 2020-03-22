package entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "Admins")
public class Admin extends User {
    public Admin(String name, Date dateOfBirth,String phoneNumber){
        super(name,dateOfBirth,phoneNumber);
    }
}
