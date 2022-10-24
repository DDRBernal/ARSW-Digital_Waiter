
package edu.eci.arsw.digital_waiter.persistence;

import edu.eci.arsw.digital_waiter.model.Ingredient;
import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Restaurant;
import edu.eci.arsw.digital_waiter.model.Table;
import edu.eci.arsw.digital_waiter.model.User;
import java.util.Set;

/**
 *
 * @author Andres - David - Juan
 */
public interface DigitalWaiterPersistence {
    

    
    public Set<Restaurant> getAllRestaurants();
    
    public Set<Ingredient> getAllIngredients();
    
    public Set<User> getUserByID(String id);
    
    public Set<Table> getAllTables();       
    
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

    public Set<Table> getTableById(String id);

    public Set<Ingredient> getIngredientById(String id);

    public Set<Plato> getPlatoById(String id);

    public Set<Menu> getMenuById(String id);

    public Set<Restaurant> getRestaurantById(String id);
    
    public void addNewUser(String name, String age, String phonenumber, String email, String password, boolean isRestaurant);
    
}
