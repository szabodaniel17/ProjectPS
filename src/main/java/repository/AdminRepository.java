package repository;

import entity.*;

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

    public List<User> getAllUsers(){

        ArrayList<User> accounts = new ArrayList<>();
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
        accounts = (ArrayList<User>) entityManager.createQuery("SELECT a FROM user a").getResultList();

        /**
         * Dupa fiecare query pe baza de date, vom face un comit pentru a realiza operatia,
         * iar dupa ce am terminat operatiile, vom inchide tranzactia.
         */
        entityManager.getTransaction().commit();
        entityManager.close();

        if(accounts == null)
            return new ArrayList<User>();
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
        /**
         * Metoda merge din EntityManager este o metoda de adaugare si actualizare in baza de date.
         * Astfel, daca vom gresi si apoi vom incerca sa readaugam acelasi user, nu vom avea erori,
         * ci acesta va fi actualizat.
         * */
        entityManager.merge(account);
        entityManager.merge(user);

        entityManager.getTransaction().commit();

        entityManager.close();

        return "Account has been created succesfully";
    }

    /**
     * Aceasta metoda este folosita pentru a actualiza un user in baza de date.
     * Account-ul va fi cautat dupa username in baza de date. Daca il gasim, acesta va
     * fi actualizat si vom returna un mesaj corespunzator.
     * Daca nu gasim un account in baza de date cu aceste credentiale, vom
     * returna un mesaj corespunzator.
     *
     * @param user
     * @param account
     * @return
     */
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

    /**
     * Aceasta metoda este folosita pentru a sterge un cont din baza de
     * date, pe baza username-ului unic. Vom cauta username-ul in baza
     * de date. Daca il vom gasi, acesta va fi sters, altfel va fi afisat
     * un mesaj corespunzator care indica lipsa acestuia in baza de date.
     *
     * @param username
     * @return
     */
    public String removeUser(String username){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Account toFind = entityManager.find(Account.class,username);
        if(toFind == null){
            entityManager.close();
            return "The user does not exist!";
        }
        /**
         * Metoda remove din EntityManager este echivalenta cu o interogare SQL
         * de DELETE.
         * */
        entityManager.remove(toFind);

        entityManager.getTransaction().commit();

        entityManager.close();

        return "Account has been removed";
    }

    /**
     * In continuare avem metode de CRUD pentru FoodItem si pentru Exercise.
     * CRUD = Create, Read, Update, Delete
     * Astfel, putem adauga, actualiza si sterge obiecte de tip FoodItem sau Exercise
     * din baza de date.
     *
     * */

    public String addFoodItems(FoodItem foodItem){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        FoodItem toFind = entityManager.find(FoodItem.class,foodItem.getId());
        if(toFind != null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "The food item already exists!";
        }

        entityManager.merge(foodItem);
        entityManager.getTransaction().commit();

        entityManager.close();

        return "Success!";
    }


    public String updateFoodItems(FoodItem foodItem){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        FoodItem toFind = entityManager.find(FoodItem.class,foodItem.getId());
        if(toFind == null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "The food item couldn't be found!";
        }

        entityManager.merge(foodItem);
        entityManager.getTransaction().commit();

        entityManager.close();

        return "Success!";
    }


    public String addExercises(Exercise exercise){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Exercise toFind = entityManager.find(Exercise.class,exercise.getId());
        if(toFind != null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "The exercise already exists!";
        }

        entityManager.merge(exercise);
        entityManager.getTransaction().commit();

        entityManager.close();

        return "Success!";
    }

    public String updateExercises(Exercise exercise){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Exercise toFind = entityManager.find(Exercise.class,exercise.getId());
        if(toFind == null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "The exercise doesn't exist!";
        }

        entityManager.merge(exercise);
        entityManager.getTransaction().commit();

        entityManager.close();

        return "Success!";
    }

    public String removeFoodItems(FoodItem foodItem){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        FoodItem toFind = entityManager.find(FoodItem.class,foodItem.getId());
        if(toFind == null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "The food item couldn't be found";
        }

        entityManager.remove(foodItem);
        entityManager.getTransaction().commit();

        entityManager.close();

        return "Success!";
    }

    public String removeExercises(Exercise exercise){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Exercise toFind = entityManager.find(Exercise.class,exercise.getId());
        if(toFind == null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "The exercise couldn't be found!";
        }

        entityManager.remove(exercise);
        entityManager.getTransaction().commit();

        entityManager.close();

        return "Success!";
    }
}
