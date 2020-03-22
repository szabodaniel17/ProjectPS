package com.example.sd2020.demo;

import entity.Account;
import entity.Admin;
import entity.Trainer;
import entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.LoginRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gymdb");
		LoginRepository loginRepo = new LoginRepository();
		Account a1 = new Account("admin","admin");
		User admin1 = new Admin("Andrei",new Date(),"0737288822",a1);
		//a1.setUser(admin1);
		Account a2 = new Account("trainer1","1234");
		User t2 = new Trainer("Vasile",new Date(),"0768292394",a2);
		//a2.setUser(t2);
		Account a3 = new Account("admi1n","ad3min");
		User test = loginRepo.checkLogin(a2);
		System.out.println(test == t2);
		System.out.println(test.toString());
		SpringApplication.run(DemoApplication.class, args);

	}

}
