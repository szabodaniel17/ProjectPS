package entity;

import javax.persistence.*;

@Entity(name = "accounts")
public class Account {

    @Id
    private String username;
    @Column
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private User user;


}
