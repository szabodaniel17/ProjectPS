package repository;

import entity.Account;
import entity.User;

public interface LoginInterface {
    /**
     * Interfata creata pentru a prelua functionalitatile clasei LoginRepository.
     * Astfel, prin aceasta interfata vom realiza Design Pattern-ul Facade, afisand doar functionalitatile
     * nu si modul in care sunt implementate.
     *
     * Se va trimite un Account care contine username si parola si se va astepta ca output un user,
     * admin sau trainer.
     */
     User checkLogin(Account account);

}
