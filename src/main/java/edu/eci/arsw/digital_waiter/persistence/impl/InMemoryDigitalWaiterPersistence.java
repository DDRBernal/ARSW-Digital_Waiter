/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.persistence.impl;

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
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private HashMap<String, ArrayList<String>> SQLQuery(String sentence) {
        HashMap<String, ArrayList<String>> result = null;
        try {
            result = sqlConnection.Query(sentence);
        } catch (SQLException ex) {
            Logger.getLogger(InMemoryDigitalWaiterPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Set<User> getAllUsers() {
        String sentence = SQLSentences.all("usuario");
        HashMap<String, ArrayList<String>> users = SQLQuery(sentence);
        return maker.makeUser(users);
    }

    @Override
    public boolean login(String email, String pswd) {

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
    public Set<Restaurant> getAllRestaurants() {
        String sentence = SQLSentences.all("restaurant");
        HashMap<String, ArrayList<String>> restaurants = SQLQuery(sentence);
        return maker.makeRestaurant(restaurants);
    }

    @Override
    public Set<Menu> getAllMenus() {
        String sentence = SQLSentences.all("menu");
        HashMap<String, ArrayList<String>> menus = SQLQuery(sentence);
        return maker.makeMenu(menus);
    }

    @Override
    public Set<Plato> getAllPlatos() {
        String sentence = SQLSentences.all("plato");
        HashMap<String, ArrayList<String>> platos = SQLQuery(sentence);
        return maker.makePlato(platos);
    }

    @Override
    public Set<Ingredient> getAllIngredients() {
        String sentence = SQLSentences.all("ingredient");
        HashMap<String, ArrayList<String>> ingredients = SQLQuery(sentence);
        return maker.makeIngredient(ingredients);
    }

    @Override
    public Set<Table> getAllTables() {
        String sentence = SQLSentences.all("mesa");
        HashMap<String, ArrayList<String>> tables = SQLQuery(sentence);
        return maker.makeTable(tables);
    }

    @Override
    public Set<User> getUserByID(String id) {

        String sentence = SQLSentences.userById(id);
        HashMap<String, ArrayList<String>> users = SQLQuery(sentence);
        return maker.makeUser(users);
    }

    @Override
    public Set<Table> getTableById(String id) {
        String sentence = SQLSentences.tableById(id);
        HashMap<String, ArrayList<String>> tables = SQLQuery(sentence);
        return maker.makeTable(tables);
    }

    @Override
    public Set<Ingredient> getIngredientById(String id) {
        String sentence = SQLSentences.ingredientById(id);
        HashMap<String, ArrayList<String>> ingredients = SQLQuery(sentence);
        return maker.makeIngredient(ingredients);
    }

    @Override
    public Set<Plato> getPlatoById(String id) {
        String sentence = SQLSentences.platoById(id);
        HashMap<String, ArrayList<String>> platos = SQLQuery(sentence);
        return maker.makePlato(platos);
    }

    @Override
    public Set<Menu> getMenuById(String id) {
        String sentence = SQLSentences.menuById(id);
        HashMap<String, ArrayList<String>> menus = SQLQuery(sentence);
        return maker.makeMenu(menus);
    }

    @Override
    public Set<Restaurant> getRestaurantById(String id) {
        String sentence = SQLSentences.restaurantById(id);
        HashMap<String, ArrayList<String>> restaurants = SQLQuery(sentence);
        return maker.makeRestaurant(restaurants);
    }

}
