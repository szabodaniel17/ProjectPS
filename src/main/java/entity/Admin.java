package entity;

import javax.persistence.Entity;
import javax.security.auth.login.AccountException;
import java.util.Date;

@Entity(name = "Admins")
public class Admin extends User {

    public Admin(){};


    public Admin(String name, Date dateOfBirth, String phoneNumber, Account account){
        super(name,dateOfBirth,phoneNumber,account);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
