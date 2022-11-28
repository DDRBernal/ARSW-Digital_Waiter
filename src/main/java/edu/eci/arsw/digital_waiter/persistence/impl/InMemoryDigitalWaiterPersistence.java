/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.persistence.impl;

import edu.eci.arsw.digital_waiter.persistence.maker.MakeModel;
import edu.eci.arsw.digital_waiter.database.JavaPostgreSQL;
import edu.eci.arsw.digital_waiter.database.SQLSentences;
import edu.eci.arsw.digital_waiter.login.Hash;
import edu.eci.arsw.digital_waiter.model.Ingredient;
import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Restaurant;
import edu.eci.arsw.digital_waiter.model.Table;
import edu.eci.arsw.digital_waiter.model.User;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistence;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistenceException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Andres - David - Juan
 */
@Component
@Qualifier("inMemory")
public class InMemoryDigitalWaiterPersistence implements DigitalWaiterPersistence {

    @Autowired
    JavaPostgreSQL sqlConnection = null;
    @Autowired
    MakeModel maker = null;

    private HashMap<String, ArrayList<String>> SQLQuery(String sentence) throws DigitalWaiterPersistenceException {
        HashMap<String, ArrayList<String>> result = null;
        try {
            synchronized(sqlConnection){
                result = sqlConnection.Query(sentence);
            }
            
        } catch (SQLException ex) {
            throw new DigitalWaiterPersistenceException(DigitalWaiterPersistenceException.ERROR_SQL_CON);
        }
        return result;
    }

    private void insertSQLQuery(String sentence) throws DigitalWaiterPersistenceException {
        try {
            sqlConnection.insertQuery(sentence);
        } catch (SQLException ex) {
            throw new DigitalWaiterPersistenceException(DigitalWaiterPersistenceException.ERROR_SQL_INSERT);
        }
    }

    @Override
    public Set<User> getAllUsers() throws DigitalWaiterPersistenceException{
        String sentence = SQLSentences.all("usuario");
        HashMap<String, ArrayList<String>> users = SQLQuery(sentence);
        return maker.makeUser(users);
    }

    @Override
    public boolean login(String email, String pswd) throws DigitalWaiterPersistenceException {

        boolean valid = false;
        pswd = Hash.hashThis(pswd);
        String sentence = SQLSentences.emailPswd(email, pswd);
        HashMap<String, ArrayList<String>> data = SQLQuery(sentence);
        if (!data.get("pswd").isEmpty()) {
            valid = true;
        }
        return valid;
    }

    @Override
    public Set<Restaurant> getAllRestaurants() throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.all("restaurant");
        HashMap<String, ArrayList<String>> restaurants = SQLQuery(sentence);
        return maker.makeRestaurant(restaurants);
    }

    @Override
    public Set<Menu> getAllMenus() throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.all("menu");
        HashMap<String, ArrayList<String>> menus = SQLQuery(sentence);
        return maker.makeMenu(menus);
    }

    @Override
    public Set<Plato> getAllPlatos() throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.all("plato");
        HashMap<String, ArrayList<String>> platos = SQLQuery(sentence);
        return maker.makePlato(platos);
    }

    @Override
    public Set<Ingredient> getAllIngredients() throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.all("ingredient");
        HashMap<String, ArrayList<String>> ingredients = SQLQuery(sentence);
        return maker.makeIngredient(ingredients);
    }

    @Override
    public Set<Table> getAllTables() throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.all("mesa");
        HashMap<String, ArrayList<String>> tables = SQLQuery(sentence);
        return maker.makeTable(tables);
    }

    @Override
    public Set<User> getUserByID(String id) throws DigitalWaiterPersistenceException {

        String sentence = SQLSentences.userById(id);
        HashMap<String, ArrayList<String>> users = SQLQuery(sentence);
        return maker.makeUser(users);
    }

    @Override
    public Set<Table> getTableById(String id) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.tableById(id);
        HashMap<String, ArrayList<String>> tables = SQLQuery(sentence);
        return maker.makeTable(tables);
    }

    @Override
    public Set<Ingredient> getIngredientById(String id) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.ingredientById(id);
        HashMap<String, ArrayList<String>> ingredients = SQLQuery(sentence);
        return maker.makeIngredient(ingredients);
    }

    @Override
    public Set<Plato> getPlatoById(String id) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.platoById(id);
        HashMap<String, ArrayList<String>> platos = SQLQuery(sentence);
        return maker.makePlato(platos);
    }

    @Override
    public Set<Menu> getMenuById(String id) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.menuById(id);
        HashMap<String, ArrayList<String>> menus = SQLQuery(sentence);
        return maker.makeMenu(menus);
    }

    @Override
    public Set<Restaurant> getRestaurantById(String id) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.restaurantById(id);
        HashMap<String, ArrayList<String>> restaurants = SQLQuery(sentence);
        return maker.makeRestaurant(restaurants);
    }

    @Override
    public void addNewUser(String name, String age, String phonenumber, String email, String password, boolean isRestaurant) throws DigitalWaiterPersistenceException {
        password = Hash.hashThis(password);
        String sentence = SQLSentences.addNewUser(name, age, phonenumber, email, password, isRestaurant);
        insertSQLQuery(sentence);
    }

    @Override
    public Set<Table> getTablesByRestaurant(String restaurantId) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.tablesByRestaurant(restaurantId);
        HashMap<String, ArrayList<String>> tables = SQLQuery(sentence);
        return maker.makeTable(tables);
    }

    @Override
    public Set<Menu> getMenusByRestaurant(String restaurantId) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.menusByRestaurant(restaurantId);
        HashMap<String, ArrayList<String>> menus = SQLQuery(sentence);
        return maker.makeMenu(menus);
    }

    @Override
    public Set<Plato> getPlatosByMenu(String menuId) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.platosByMenu(menuId);
        HashMap<String, ArrayList<String>> platos = SQLQuery(sentence);
        return maker.makePlato(platos);
    }

    @Override
    public Set<Ingredient> getInredientByPlato(String platoId) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.ingredentByPlato(platoId);
        HashMap<String, ArrayList<String>> ingredients = SQLQuery(sentence);
        return maker.makeIngredient(ingredients);
    }

    @Override
    public Set<Plato> getPlatosByrestaurant(String restaurantId) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.platosByRestaurant(restaurantId);
        HashMap<String, ArrayList<String>> platos = SQLQuery(sentence);
        return maker.makePlato(platos);
    }

    @Override
    public void setTableDisponibilityByRestaurant(String idTable, String idRestaurant, boolean state) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.setTableDisponibilityByRestaurant(idRestaurant, idTable, state);
        insertSQLQuery(sentence);
    }

    @Override
    public Set<Restaurant> getRestaurantByUser(String userId) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.restaurantsByUser(userId);
        HashMap<String, ArrayList<String>> restaurants = SQLQuery(sentence);
        return maker.makeRestaurant(restaurants);
    }

    @Override
    public void addNewRestaurant(String name, String address, String phonenumber, String idUsuario) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.addRestaurant(name, address, phonenumber, idUsuario);
        insertSQLQuery(sentence);
    }

    @Override
    public Set<User> getUserByEmail(String email) throws DigitalWaiterPersistenceException {
        String sentence = SQLSentences.userByEmail(email);
        HashMap<String, ArrayList<String>> user = SQLQuery(sentence);
        return maker.makeUser(user);
    }
}
