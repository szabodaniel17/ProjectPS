package business;

import entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import repository.LoginRepo;

public class LoginService {
    private LoginRepo loginRepo;

    public LoginService(LoginRepo loginRepo){
        this.loginRepo = loginRepo;
    }

    @GetMapping("/attemptLogin") // localhost:8080/attemptLogin
    public User attemptLogin(String username, String password){
        //Account toBeLoggedIn = new Account(username,password);
        //User user = loginRepo.attemptLogin(toBeLoggedIn);
        //if(user == null)
       //     System.out.println("Login attempt failed");
       return null;
    }
}
