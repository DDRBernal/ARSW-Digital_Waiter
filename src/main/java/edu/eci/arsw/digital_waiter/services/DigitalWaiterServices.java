package edu.eci.arsw.digital_waiter.services;

import edu.eci.arsw.digital_waiter.model.Ingredient;
import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Restaurant;
import edu.eci.arsw.digital_waiter.model.User;
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
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Ingredient> getAllIngredients()throws DigitalWaiterPersistenceException{
        return dpp.getAllIngredients();
    }
    /**
     * 
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Restaurant> getAllRestaurants() throws DigitalWaiterPersistenceException{
        return dpp.getAllRestaurants();
    }
    /**
     * 
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Menu> getAllMenus() throws DigitalWaiterPersistenceException{
        return dpp.getAllMenus();
    }
    /**
     * 
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Plato> getAllPlatos() throws DigitalWaiterPersistenceException{
        return dpp.getAllPlatos();
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

    

}
