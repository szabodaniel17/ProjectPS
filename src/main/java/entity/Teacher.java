package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity(name = "Teachers")
public class Teacher extends User {

    public Teacher(){};

    public Teacher(String name, Date dateOfBirth, Account account) {
        super(name, dateOfBirth, account);

    }
}
