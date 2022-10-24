package edu.eci.arsw.digital_waiter.services;

import edu.eci.arsw.digital_waiter.model.User;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterNotFoundException;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistenceException;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistence;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @authors Andres - David - Juan
 */
@Service
public class DigitalWaiterServices {
   
    @Autowired
    DigitalWaiterPersistence dpp=null;

    /**
     *
     * @param user
     * @throws DigitalWaiterPersistenceException
     */
    public void addNewUser(User user) throws DigitalWaiterPersistenceException {
        dpp.saveUser(user);
    }

    /**
     *
     * @return
     * @throws DigitalWaiterPersistenceException
     */
    public Set<User> getAllUsers() throws DigitalWaiterPersistenceException {
        return dpp.getAllUsers();
    }
    
    public boolean login(String email, String pswd) throws DigitalWaiterPersistenceException{
        return dpp.login(email, pswd);
    }

    /**
     *
     * @param name
     * @return the user given name
     */
    public User getUserByName(String name) throws DigitalWaiterNotFoundException {
        return dpp.getUser(name);
    }

}
