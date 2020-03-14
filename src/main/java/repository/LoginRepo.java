package repository;

import com.example.sd2020.demo.Konstants;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LoginRepo {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Konstants.DB_NAME);

    public LoginRepo(){};
}
