package repository;

import entity.Account;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LoginRepository{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gymdb");

    public LoginRepository(){};

    /**
     * Aceasta metoda este folosita pentru a verifica credentialele unui account.
     * Folosind metoda find din EntityManager, vom cauta in baza de date username-ul,
     * apoi parola, si daca ambele vor fi gasite, vom cauta user-ul legat la eles.
     * @param account
     * @return
     */
    public User checkLogin(Account account){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Account matchAccount = entityManager.find(Account.class,account.getUsername());
        if(matchAccount == null){
            entityManager.close();
            System.out.println("User not found");
            return null;
        }

        if(!account.getPassword().equals(matchAccount.getPassword())) {
            entityManager.close();
            System.out.println("Passwords don't match");
            return null;
        }

        Query q = entityManager.createQuery("SELECT u FROM user u WHERE username = '" + account.getUsername()+"'");
        entityManager.getTransaction().commit();
        User user = (User) q.getResultList().get(0);

        entityManager.close();

        if(user == null)
            return null;

        System.out.println("Login was successful");
        return user;
    }

}
