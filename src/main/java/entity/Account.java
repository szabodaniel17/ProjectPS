package entity;

import javax.persistence.*;

@Entity(name = "accounts")
public class Account {

    @Id
    private String username;
    @Column
    private String password;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    public Account(){}

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                '}';
    }
}
