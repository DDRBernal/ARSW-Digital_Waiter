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
 * Clase que presta los servicios principales de digital waiter
 * @authors Andres - David - Juan
 */
@Service
public class DigitalWaiterServices {
    
    //Inyeccion del componente de persistencia
    @Autowired
    DigitalWaiterPersistence dpp = null;

    /**
     * Consulta todos los ingredientes en la base de datos 
     * @return Set con objetos de tipo Ingrediente 
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Ingredient> getAllIngredients() throws DigitalWaiterPersistenceException {
        return dpp.getAllIngredients();
    }

    /**
     * Consulta todos los restaurantes en la base de datos 
     * @return Set con objetos de tipo Restaurant
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Restaurant> getAllRestaurants() throws DigitalWaiterPersistenceException {
        return dpp.getAllRestaurants();
    }

    /**
     * Consulta todos los menu en la base de datos 
     * @return Set con objetos de tipo Menu
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Menu> getAllMenus() throws DigitalWaiterPersistenceException {
        return dpp.getAllMenus();
    }

    /**
     * Consulta todos los platos en la base de datos 
     * @return Set con objetos de tipo Plato
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Plato> getAllPlatos() throws DigitalWaiterPersistenceException {
        return dpp.getAllPlatos();
    }

    /**
     * Consulta todos las mesas en la base de datos 
     * @return Set con objetos de tipo Table
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Table> getAllTables() throws DigitalWaiterPersistenceException {
        return dpp.getAllTables();
    }

    /**
     * Consulta el usuario dado con su id
     * @param id id del usuario
     * @return Set con el objeto User
     * @throws DigitalWaiterPersistenceException
     */
    public Set<User> getUserByID(String id) throws DigitalWaiterPersistenceException {
        return dpp.getUserByID(id);
    }
    
    /**
     * Consulta el usuario dado con su email
     * @param email email del usuario
     * @return Set con el objeto User
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<User> getUserByEmail(String email) throws DigitalWaiterPersistenceException {
        return dpp.getUserByEmail(email);
    }

    /**
     * Consulta una mesa con su respectivo id en la base de datos
     * @param id id de la mesa
     * @return Set con el objeto Table
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Table> getTableById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getTableById(id);
    }
    /**
     * Consulta las mesas que posee un restaurante dado el id del restaurante en la base de datos
     * @param restaurantId id del restaurante
     * @return Set con objetos de tipo Table
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Table> getTablesByRestaurant(String restaurantId)throws DigitalWaiterPersistenceException{
        return dpp.getTablesByRestaurant(restaurantId);
    }
    /**
     * Consulta los menus que posee un restaurante dado el id del restaurant en la base de datos
     * @param restaurantId id del restaurante
     * @return Set con objetos de tipo Menu
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Menu> getMenusByRestaurant(String restaurantId)throws DigitalWaiterPersistenceException{
        return dpp.getMenusByRestaurant(restaurantId);
    }
    /**
     * Consulta los platos que conforman un Menu dado el id del menu en la base de datos
     * @param menuId id del menu
     * @return Set con objetos de tipo Plato
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Plato> getPlatosByMenu(String menuId)throws DigitalWaiterPersistenceException{
        return dpp.getPlatosByMenu(menuId);
    }

    /**
     * Consulta un ongrediente dado su id en la base de datos
     * @param id id del ingrediente
     * @return Set con el objeto Ingredient
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Ingredient> getIngredientById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getIngredientById(id);
    }

    /**
     * Consulta un plato dado su id en la base de datos
     * @param id id del Plato
     * @return Set con el objeto Plato
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Plato> getPlatoById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getPlatoById(id);
    }
    
    /**
     * Consulta los ingredientes que conforman a un plato dado el id del plato en la base de datos
     * @param platoId id del plato
     * @return Set con objetos de tipo Plato
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Ingredient> getInredientByPlato(String platoId) throws DigitalWaiterPersistenceException {
        return dpp.getInredientByPlato(platoId);
    }

    /**
     * Consulta un menu dado su id en la base de datos
     * @param id id del menu
     * @return Set con el objeto Menu
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Menu> getMenuById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getMenuById(id);
    }

    /**
     * Consulta un restaurante dado su id en la base de datos
     * @param id id del restaurante
     * @return Set con el objeto Restaurant
     * @throws DigitalWaiterPersistenceException
     */
    public Set<Restaurant> getRestaurantById(String id) throws DigitalWaiterPersistenceException {
        return dpp.getRestaurantById(id);
    }

    /**
     * Consulta todos los usuaios en la base de datos
     * @return Set con los objetos de tipo User
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<User> getAllUsers() throws DigitalWaiterPersistenceException {
        return dpp.getAllUsers();
    }
    
    /**
     * Consulta los platos que ofrece un restaurante dado el id del restaurante en la base de datos 
     * @param restaurantId id del restaurante
     * @return Set con los objetos de tipo Plato
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Plato> getPlatosByrestaurant(String restaurantId)throws DigitalWaiterPersistenceException{
        return dpp.getPlatosByrestaurant(restaurantId);
    }
    /**
     * Consulta los restaurantes asociados a una cuenta usuario dado el id del usuario en la base de datos
     * @param userId id del usuario
     * @return Set con los objetos de tipo Restaurant
     * @throws DigitalWaiterPersistenceException 
     */
    public Set<Restaurant> getRestaurantByUser(String userId) throws DigitalWaiterPersistenceException{
        return dpp.getRestaurantByUser(userId);
    }

    /**
     * Valida el login de un usuario dado su email y contraseña en la base de datos
     * @param email emailproporcionado por el usuario
     * @param pswd contraseña proporcionada por el usuario
     * @return booleano indicando el login satisfactorio o insatisfactorio
     * @throws DigitalWaiterPersistenceException
     */
    public boolean login(String email, String pswd) throws DigitalWaiterPersistenceException {
        return dpp.login(email, pswd);
    }
    /**
     * Agrega a un nuevo usuario a la base de datos
     * @param name nombre del usuario
     * @param age edad del usuario
     * @param phonenumber numero telefonico del usuario
     * @param email email del usuario
     * @param password contraseña del usuario
     * @param isRestaurant indica si el usuario es propietario de un restaurante
     * @throws DigitalWaiterPersistenceException 
     */
    public void addNewUser(String name, String age, String phonenumber, String email, String password, boolean isRestaurant) throws DigitalWaiterPersistenceException {
         dpp.addNewUser(name, age, phonenumber, email,  password, isRestaurant);
    }
    
    /**
     * Agrega a un restaurante a la base de datos
     * @param name nombre del restaurante
     * @param address direccion del restaurante
     * @param phonenumber nomero telefonico del restaurante
     * @param idUsuario id del usuario administrador del restaurante
     * @throws DigitalWaiterPersistenceException 
     */
    public void addNewRestaurant( String name, String address, String phonenumber, String idUsuario) throws DigitalWaiterPersistenceException {
         dpp.addNewRestaurant( name, address, phonenumber, idUsuario);
    }
    /**
     * Cambia el estado de disponibilidad de una mesa en un restaurante dado el id de la mesa y el restaurante en la base de datos
     * @param idTable id de la mesa
     * @param idRestaurant id del restaurante
     * @param state estado de la disponibilidad de la mesa
     * @throws DigitalWaiterPersistenceException 
     */
    public void setTableDisponibilityByRestaurant( String idTable, String idRestaurant, boolean state)throws DigitalWaiterPersistenceException{
        dpp.setTableDisponibilityByRestaurant( idTable, idRestaurant, state);
    }
    
    /**
     * Consulta si un usuario es administrador o no dado su email en la base de datos
     * @param email email del usuario
     * @return booleano indicando si el usuario es administrador o no
     * @throws DigitalWaiterPersistenceException 
     */
    public boolean imIAdmin( String email)throws DigitalWaiterPersistenceException{
        return getUserByEmail(email).iterator().next() instanceof Admin;
    }
    
    /**
     * Agrega una nueva mesa disponible en el restaurante dado su id en la base de datos
     * @param idRestaurant id del restaurante
     * @param name nombre de la nueva mesa 
     * @throws DigitalWaiterPersistenceException 
     */
    public void addNewteableRestaurant( String idRestaurant, String name) throws DigitalWaiterPersistenceException {
         dpp.addNewteableRestaurant( idRestaurant, name);
    }
}
