package repository;

import com.example.sd2020.demo.Konstants;
import entity.Account;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LoginRepository implements LoginRepo{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(Konstants.DB_NAME);
    private static LoginRepository singletone = null;

    private LoginRepository(){};

    public static LoginRepository getInstance(){
        if(singletone == null)
            singletone = new LoginRepository();
        return singletone;
    }

    public String addUser(User user){
        /**
         * Pentru fiecare metoda se instantiaza un entiy manager din EMF-ul de mai sus.
         */
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /**
         * Denota ca incepe o operatie pe baza de date
         */
        entityManager.getTransaction().begin();
        /**
         * Declaram operatia sau operatiile ce se vor face pe BD.
         */
        User existingUser = entityManager.find(User.class, user.id);
        if(existingUser != null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Username already exists!";
        }
        entityManager.merge(user);
        /**
         * Executam operatia.
         */
        entityManager.getTransaction().commit();
        /**
         * Inchidem EM-ul. Ca la operatii pe fisiere, il deschizi, il citesti si in final il inchizi.
         */
        entityManager.close();
        return "Success!";
    }

    public String addAccount(Account account){
        /**
         * Pentru fiecare metoda se instantiaza un entiy manager din EMF-ul de mai sus.
         */
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /**
         * Denota ca incepe o operatie pe baza de date
         */
        entityManager.getTransaction().begin();
        /**
         * Declaram operatia sau operatiile ce se vor face pe BD.
         */
        /*Account existingAcc = entityManager.find(Account.class, account.username);
        if(existingAcc != null){
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Username already exists!";
        }*/
        entityManager.merge(account);
        /**
         * Executam operatia.
         */
        entityManager.getTransaction().commit();
        /**
         * Inchidem EM-ul. Ca la operatii pe fisiere, il deschizi, il citesti si in final il inchizi.
         */
        entityManager.close();
        return "Success!";
    }

    @Override
    public User attemptLogin(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Account toFind = entityManager.find(Account.class, account.getUsername());
        entityManager.getTransaction().commit();

        if(toFind == null){
            entityManager.close();
            return null;
        }
        if(!toFind.getPassword().equals(account.getPassword())){
            entityManager.close();
            return null;
        }

        User user = searchUser(entityManager,toFind);
        entityManager.close();
        return user;
    }

    private User searchUser(EntityManager entityManager, Account founded){
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("SELECT t FROM Teachers t WHERE username = '" + founded.getUsername()+"'");
        entityManager.getTransaction().commit();
        User teacher = (User) q.getResultList().get(0);
        if(teacher != null)
            return teacher;

        entityManager.getTransaction().begin();
        q = entityManager.createQuery("SELECT s FROM Students s WHERE username = '" + founded.getUsername()+"'");
        entityManager.getTransaction().commit();
        User student = (User) q.getResultList().get(0);
        return student;
    }
}
