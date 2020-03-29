package repository;

import entity.Account;
import entity.Trainer;
import entity.User;

import javax.persistence.*;
import java.util.*;

public class AdminRepository implements AdminInterface {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gymdb");

    /**
     * Metoda returneaza toate account-urile din baza de date
     * @return
     */
    public List<Account> getAllAccounts(){

        ArrayList<Account> accounts = new ArrayList<Account>();
        /**
         * Pentru fiecare metoda, vom crea un entityManager pentru a gestiona
         * operatiile pe baza de date, instantiat din EntityManagerFactory
         */
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        /**
         * Se face cast la ArrayList si vom face append la fiecare valoare gasita
         * in tabela accounts in lista accounts.
         */
        accounts = (ArrayList<Account>) entityManager.createQuery("SELECT a FROM accounts a").getResultList();

        /**
         * Dupa fiecare query pe baza de date, vom face un comit pentru a realiza operatia,
         * iar dupa ce am terminat operatiile, vom inchide tranzactia.
         */
        entityManager.getTransaction().commit();
        entityManager.close();

        if(accounts == null)
            return new ArrayList<Account>();
        return accounts;
    }

    /**
     * Aceasta metoda este folosita pentru a adauga un user in baza de date.
     * Account-ul va fi cautat dupa username in baza de date. Daca il gasim,
     * vom returna un mesaj corespunzator.
     * Daca nu gasim un account in baza de date cu aceste credentiale, vom adauga
     * un user si un account in baza de date.
     *
     * @param user
     * @param account
     * @return
     */
    public String addNewUser(User user, Account account){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Account toFind = entityManager.find(Account.class,account.getUsername());

        if(toFind != null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Username already exists";
        }

        entityManager.merge(account);
        entityManager.merge(user);

        entityManager.getTransaction().commit();

        entityManager.close();

        return "Account has been created succesfully";
    }

    public String updateUser(User user, Account account){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Account toFind = entityManager.find(Account.class,account.getUsername());

        if(toFind == null){
            //entityManager.getTransaction().commit();
            entityManager.close();
            return "Username does not exists";
        }

        entityManager.merge(account);
        entityManager.merge(user);

        entityManager.getTransaction().commit();

        entityManager.close();

        return "Account has been modified succesfully";
    }

    public String removeUser(String username){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Account toFind = entityManager.find(Account.class,username);
        if(toFind == null){
            entityManager.close();
            return "The user does not exist!";
        }

        entityManager.remove(toFind);

        entityManager.getTransaction().commit();

        entityManager.close();

        return "Account has been removed";
    }

    public String addFoodItems(){
        return "Success!";
    }

    public String addExercises(){
        return "Success";
    }

    public String removeFoodItems(){
        return "Success!";
    }

    public String removeExercises(){
        return "Success";
    }
}
