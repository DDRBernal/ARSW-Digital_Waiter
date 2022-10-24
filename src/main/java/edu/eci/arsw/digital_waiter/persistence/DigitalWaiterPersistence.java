
package edu.eci.arsw.digital_waiter.persistence;

import edu.eci.arsw.digital_waiter.model.Ingredient;
import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Restaurant;
import edu.eci.arsw.digital_waiter.model.User;
import java.util.Set;

/**
 *
 * @author Andres - David - Juan
 */
public interface DigitalWaiterPersistence {
    

    
    public Set<Restaurant> getAllRestaurants();
    
    public Set<Ingredient> getAllIngredients();
    
    /**
     * 
     * @return 
     */
    public Set<Menu> getAllMenus();
    /**
     *
     * @return the user of the given name
     */
    public Set<Plato> getAllPlatos();

    Set<User> getAllUsers() ;
    
    public boolean login (String email, String pswd);
    
}
