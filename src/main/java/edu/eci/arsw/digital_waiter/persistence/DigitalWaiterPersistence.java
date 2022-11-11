
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
    
    public Set<Menu> getAllMenus();

    public Set<Plato> getAllPlatos();

    public Set<User> getAllUsers() ;
    
    public boolean login (String email, String pswd);

    public Set<Table> getTableById(String id);

    public Set<Ingredient> getIngredientById(String id);

    public Set<Plato> getPlatoById(String id);

    public Set<Menu> getMenuById(String id);

    public Set<Restaurant> getRestaurantById(String id);
    
    public void addNewUser(String name, String age, String phonenumber, String email, String password, boolean isRestaurant);

    public Set<Table> getTablesByRestaurant(String restaurantId);

    public Set<Menu> getMenusByRestaurant(String restaurantId);

    public Set<Plato> getPlatosByMenu(String menuId);

    public Set<Ingredient> getInredientByPlato(String platoId);

    public Set<Plato> getPlatosByrestaurant(String restaurantId);

    public void setTableDisponibilityByRestaurant(String idTable, String idRestaurant, boolean state);

    public Set<Restaurant> getRestaurantByUser(String userId);

    public void addNewRestaurant(String name, String address, String phonenumber, String idUsuario);

    public Set<User> getUserByEmail(String email);
}
