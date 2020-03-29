package service;

import entity.Account;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import repository.LoginInterface;

@Controller
public class LoginService {
    private LoginInterface loginRepo;

    public LoginService(LoginInterface loginRepo){
        this.loginRepo = loginRepo;
    }

    @GetMapping("/checkLogin") // localhost:8080/checkLogin
    public User checkLogin(String username, String password){
        Account loginAttempt = new Account(username,password);
        User result = loginRepo.checkLogin(loginAttempt);
        if(result == null){
            System.out.println("Login Failed");
        }
        return result;
    }
}
