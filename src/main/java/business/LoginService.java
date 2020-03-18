package business;

import entity.Account;
import entity.User;
import repository.LoginRepo;

public class LoginService {
    private LoginRepo loginRepo;

    public LoginService(LoginRepo loginRepo){
        this.loginRepo = loginRepo;
    }

    public User attemptLogin(String username, String password){
        Account toBeLoggedIn = new Account(username,password);
        User user = loginRepo.attemptLogin(toBeLoggedIn);
        if(user == null)
            System.out.println("Login attempt failed");
        return user;
    }
}
