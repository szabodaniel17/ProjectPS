package repository;

import entity.Account;
import entity.User;

public interface LoginRepo {

    /**
     * It returns an instance of a loginRepo object.
     *
     * @return an instance of a LoginRepo object
     */
    static LoginRepo getInstance(){
        return LoginRepository.getInstance();
    }

    /**
     * Search if there is any user with the credentials saved in an
     * account object type received as parameter.
     *
     * It returns the user associated with the account if exist,
     * null otherwise.
     *
     * @param account the credentials to be searched in database
     * @return user associated with the account or null
     */
    User attemptLogin(Account account);
}
