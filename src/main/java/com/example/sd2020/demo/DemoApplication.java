package com.example.sd2020.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gymdb");
		//LoginRepo loginRepo = new LoginRepo();
		//Account a1 = new Account("teach1","123");
		//User t1 = new Teacher("Ion",new Date(),a1);
		//a1.setUser(t1);
		//loginRepo.addAccount(a1);
		//loginRepo.addUser(t1);
	//	Account a2 = new Account("teach2","1234");
		//User s2 = new Student("Gheorghe",new Date(),a2);
		//a2.setUser(s2);
		//loginRepo.addAccount(a2);
		//loginRepo.addUser(s2);
		//SpringApplication.run(DemoApplication.class, args);
		//LoginService loginService = new LoginService(LoginRepo.getInstance());
		//User user = loginService.attemptLogin("teach1", "123");
		//System.out.println(user.name);
		//System.out.println("Teacher: "+ (user instanceof Teacher));
		//System.out.println("Student: "+ (user instanceof Student));
	}

}
