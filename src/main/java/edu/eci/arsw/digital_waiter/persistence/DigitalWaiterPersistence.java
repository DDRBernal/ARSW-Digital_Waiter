
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
    

    
    public Set<Restaurant> getAllRestaurants() throws DigitalWaiterPersistenceException;
    
    public Set<Ingredient> getAllIngredients() throws DigitalWaiterPersistenceException;
    
    public Set<User> getUserByID(String id) throws DigitalWaiterPersistenceException;
    
    public Set<Table> getAllTables() throws DigitalWaiterPersistenceException;       
    
    public Set<Menu> getAllMenus() throws DigitalWaiterPersistenceException;

    public Set<Plato> getAllPlatos() throws DigitalWaiterPersistenceException;

    public Set<User> getAllUsers() throws DigitalWaiterPersistenceException;
    
    public boolean login (String email, String pswd) throws DigitalWaiterPersistenceException;

    public Set<Table> getTableById(String id) throws DigitalWaiterPersistenceException;

    public Set<Ingredient> getIngredientById(String id) throws DigitalWaiterPersistenceException;

    public Set<Plato> getPlatoById(String id) throws DigitalWaiterPersistenceException;

    public Set<Menu> getMenuById(String id) throws DigitalWaiterPersistenceException;

    public Set<Restaurant> getRestaurantById(String id) throws DigitalWaiterPersistenceException;
    
    public void addNewUser(String name, String age, String phonenumber, String email, String password, boolean isRestaurant) throws DigitalWaiterPersistenceException;

    public Set<Table> getTablesByRestaurant(String restaurantId) throws DigitalWaiterPersistenceException;

    public Set<Menu> getMenusByRestaurant(String restaurantId) throws DigitalWaiterPersistenceException;

    public Set<Plato> getPlatosByMenu(String menuId) throws DigitalWaiterPersistenceException;

    public Set<Ingredient> getInredientByPlato(String platoId) throws DigitalWaiterPersistenceException;

    public Set<Plato> getPlatosByrestaurant(String restaurantId) throws DigitalWaiterPersistenceException;

    public void setTableDisponibilityByRestaurant(String idTable, String idRestaurant, boolean state) throws DigitalWaiterPersistenceException;

    public Set<Restaurant> getRestaurantByUser(String userId) throws DigitalWaiterPersistenceException;

    public void addNewRestaurant(String name, String address, String phonenumber, String idUsuario) throws DigitalWaiterPersistenceException;

    public Set<User> getUserByEmail(String email) throws DigitalWaiterPersistenceException;

    public void addNewteableRestaurant(String idRestaurant, String name) throws DigitalWaiterPersistenceException;
}
