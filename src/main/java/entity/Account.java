package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "accounts")
public class Account{
    @Id
    private String username;
    @Column
    private String password;

    //@OneToOne(fetch=FetchType.LAZY, targetEntity = Parent.class)
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private User user;

    public Account(){
    };

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public User getUser() {
        return user;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
