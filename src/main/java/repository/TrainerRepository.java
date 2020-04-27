package repository;

import entity.Exercise;
import entity.FoodItem;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TrainerRepository implements TrainerInterface {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gymdb");

    /**
     * Metoda folosita pentru a extrage din baza de date toate alimentele.
     * Datele extrase vor fi stocate intr-o lista si returnate.
     *
     * */
    public List<FoodItem> getAllFoodItems(){
        List<FoodItem> foodItems = new ArrayList<FoodItem>();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        foodItems = (ArrayList<FoodItem>) entityManager.createQuery("SELECT a FROM fooditem a").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        if(foodItems == null){
            return new ArrayList<FoodItem>();
        }

        return foodItems;
    }

    /**
     * Metoda folosita pentru a extrage din baza de date toate exercitiile.
     * Datele extrase vor fi stocate intr-o lista si returnate.
     *
     * */
    public List<Exercise> getAllExercises(){
        List<Exercise> exercises = new ArrayList<>();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        exercises = (ArrayList<Exercise>) entityManager.createQuery("SELECT a FROM exercise a").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        if(exercises == null){
            return new ArrayList<Exercise>();
        }

        return exercises;
    }

    /**
     * De asemenea ne dorim ca un Trainer sa poata adauga in baza de date, alimente, precum si
     * exercitii.
     *
     * */
    public String addFoodItems(FoodItem foodItem){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        FoodItem toFind = entityManager.find(FoodItem.class,foodItem);
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

    public String addExercises(Exercise exercise){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Exercise toFind = entityManager.find(Exercise.class,exercise);
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



}
