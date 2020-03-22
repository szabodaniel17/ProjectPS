package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "user")
public abstract class User {

    @Id
    public final String id;
    @Column
    public String name;
    @Column
    public final Date dateOfBirth;
    @Column
    public String phoneNumber;

    /*
    @OneToOne
    @JoinColumn(name="username")
    public Account account;*/

    User(){
        dateOfBirth = new Date();
        id = UUID.randomUUID().toString();
    }

    User(String name, Date dateOfBirth,String phoneNumber) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name) &&
                dateOfBirth.equals(user.dateOfBirth) &&
                phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth, phoneNumber);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}