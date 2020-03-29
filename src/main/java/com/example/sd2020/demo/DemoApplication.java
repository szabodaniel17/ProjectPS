package com.example.sd2020.demo;

import entity.Account;
import entity.Admin;
import entity.Trainer;
import entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.AdminRepository;
import repository.LoginInterface;
import repository.LoginRepository;
import service.LoginService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gymdb");
		LoginRepository loginRepo = new LoginRepository();
		LoginService serv = new LoginService(loginRepo);
		AdminRepository admin = new AdminRepository();
		Account a1 = new Account("admin","admin");
		User admin1 = new Admin("Andrei",new Date(),"0737288822",a1);
		Account a2 = new Account("trainer1","1234");
		User t2 = new Trainer("Vasile",new Date(),"0768292394",a2);
		Account a3 = new Account("admi1n","ad3min");
		User test = loginRepo.checkLogin(a2);
		User test1 = serv.checkLogin(a1.getUsername(),a1.getPassword());
		ArrayList<Account> a = (ArrayList<Account>) admin.getAllAccounts();
		System.out.println(a.toString());
		System.out.println(test.equals(t2));
		System.out.println(test.toString()+"\n" + test1.toString());
		SpringApplication.run(DemoApplication.class, args);

	}

}
