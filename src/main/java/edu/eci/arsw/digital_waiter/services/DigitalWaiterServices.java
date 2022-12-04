package edu.eci.arsw.digital_waiter.services;

import edu.eci.arsw.digital_waiter.model.Admin;
import edu.eci.arsw.digital_waiter.model.Ingredient;
import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Restaurant;
import edu.eci.arsw.digital_waiter.model.Table;
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
    DigitalWaiterPersistence dpp = null;

    /**
     *
     * @return @throws DigitalWaiterPersistenceException
     */
    public Set<Ingredient> getAllIngredients() throws DigitalWaiterPersistenceException {
        return dpp.getAllIngredients();
    }

    /**
     *
     * @return @throws DigitalWaiterPersistenceException
     */
    public Set<Restaurant> getAllRestaurants() throws DigitalWaiterPersistenceException {
        return dpp.getAllRestaurants();
    }

    /**
     *
     * @return @throws DigitalWaiterPersistenceException
     */
    public Set<Menu> getAllMenus() throws DigitalWaiterPersistenceException {
        return dpp.getAllMenus();
    }

    /**
     *
     * @return @throws DigitalWaiterPersistenceException
     */
    public Set<Plato> getAllPlatos() throws DigitalWaiterPersistenceException {
        return dpp.getAllPlatos();
    }

    /**
     *
     * @return @throws DigitalWaiterPersistenceException
     */
    public Set<Table> getAllTables() throws DigitalWaiterPersistenceException {
        return dpp.getAllTables();
    }

    /**
     *
     * @param id
     * @return
     * @throws DigitalWaiterPersistenceException
     */
    public Set<User> getUserByID(String id) throws DigitalWaiterPersistenceException {
        return dpp.getUserByID(id);
    }
    
    /**
     * 
     * @param email
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<User> getUserByEmail(String email) throws DigitalWaiterPersistenceException {
        return dpp.getUserByEmail(email);
    }

    /**
     *
     * @param id
     * @return
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Table> getTableById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getTableById(id);
    }
    /**
     * 
     * @param restaurantId
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Table> getTablesByRestaurant(String restaurantId)throws DigitalWaiterPersistenceException{
        return dpp.getTablesByRestaurant(restaurantId);
    }
    /**
     * 
     * @param restaurantId
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Menu> getMenusByRestaurant(String restaurantId)throws DigitalWaiterPersistenceException{
        return dpp.getMenusByRestaurant(restaurantId);
    }
    /**
     * 
     * @param menuId
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Plato> getPlatosByMenu(String menuId)throws DigitalWaiterPersistenceException{
        return dpp.getPlatosByMenu(menuId);
    }

    /**
     *
     * @param id
     * @return
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Ingredient> getIngredientById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getIngredientById(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Plato> getPlatoById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getPlatoById(id);
    }
    
    public Set<Ingredient> getInredientByPlato(String platoId) throws DigitalWaiterPersistenceException {
        return dpp.getInredientByPlato(platoId);
    }

    /**
     *
     * @param id
     * @return
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Menu> getMenuById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getMenuById(id);
    }

    /**
     *
     * @param id
     * @return
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Restaurant> getRestaurantById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getRestaurantById(id);
    }

    /**
     *
     * @return @throws DigitalWaiterPersistenceException
     */
    public Set<User> getAllUsers() throws DigitalWaiterPersistenceException {
        return dpp.getAllUsers();
    }
    
    /**
     * 
     * @param restaurantId
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Plato> getPlatosByrestaurant(String restaurantId)throws DigitalWaiterPersistenceException{
        return dpp.getPlatosByrestaurant(restaurantId);
    }
    /**
     * 
     * @param userId
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Restaurant> getRestaurantByUser(String userId) throws DigitalWaiterPersistenceException{
        return dpp.getRestaurantByUser(userId);
    }

    /**
     *
     * @param email
     * @param pswd
     * @return
     * @throws DigitalWaiterPersistenceException
     */
    public boolean login(String email, String pswd) throws DigitalWaiterPersistenceException {
        return dpp.login(email, pswd);
    }
    /**
     * 
     * @param name
     * @param age
     * @param phonenumber
     * @param email
     * @param password
     * @param isRestaurant
     * @throws DigitalWaiterPersistenceException 
     */
    public void addNewUser(String name, String age, String phonenumber, String email, String password, boolean isRestaurant) throws DigitalWaiterPersistenceException {
         dpp.addNewUser(name, age, phonenumber, email,  password, isRestaurant);
    }
    
    /**
     * 
     * @param name
     * @param address
     * @param phonenumber
     * @param idUsuario
     * @throws DigitalWaiterPersistenceException 
     */
    public void addNewRestaurant( String name, String address, String phonenumber, String idUsuario) throws DigitalWaiterPersistenceException {
         dpp.addNewRestaurant( name, address, phonenumber, idUsuario);
    }
    /**
     * 
     * @param idTable
     * @param idRestaurant
     * @param state
     * @throws DigitalWaiterPersistenceException 
     */
    public void setTableDisponibilityByRestaurant( String idTable, String idRestaurant, boolean state)throws DigitalWaiterPersistenceException{
        dpp.setTableDisponibilityByRestaurant( idTable, idRestaurant, state);
    }
    
    /**
     * 
     * @param email
     * @return
     * @throws DigitalWaiterPersistenceException 
     */
    public boolean imIAdmin( String email)throws DigitalWaiterPersistenceException{
        return getUserByEmail(email).iterator().next() instanceof Admin;
    }

}
