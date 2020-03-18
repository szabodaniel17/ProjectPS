package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    @OneToOne
    @JoinColumn(name="username")
    public Account account;

    User(){
        dateOfBirth = new Date();
        id = UUID.randomUUID().toString();
    }

    User(String name, Date dateOfBirth, Account account) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.account = account;
        id = UUID.randomUUID().toString();
    }

}