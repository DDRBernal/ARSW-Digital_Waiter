/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.persistence.impl;

import edu.eci.arsw.digital_waiter.database.SQLSentences;
import edu.eci.arsw.digital_waiter.database.databaseImpl.JavaPostgreSQLBasic;
import edu.eci.arsw.digital_waiter.login.Hash;
import edu.eci.arsw.digital_waiter.model.Client;
import edu.eci.arsw.digital_waiter.model.Admin;
import edu.eci.arsw.digital_waiter.model.Ingredient;
import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Restaurant;
import edu.eci.arsw.digital_waiter.model.User;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistence;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
    JavaPostgreSQLBasic sqlConnection;

    @Override
    public Set<User> getAllUsers() {
        Set<User> set = new HashSet<>();
        String sentence = SQLSentences.all("usuario");
        try {
            HashMap<String, ArrayList<String>> users = sqlConnection.Query(sentence);
            int p = 0;
            for (String i : users.get("isadmin")) {
                User us = null;
                if ("f".equals(i)) {
                    us = new Client(users.get("id").get(p), users.get("name").get(p), users.get("phonenumber").get(p), users.get("email").get(p), users.get("age").get(p), users.get("pswd").get(p));
                } else if ("t".equals(i)) {
                    us = new Admin(users.get("id").get(p), users.get("name").get(p), users.get("phonenumber").get(p), users.get("email").get(p), users.get("age").get(p), users.get("pswd").get(p));
                }
                set.add(us);
                p += 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InMemoryDigitalWaiterPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }

    @Override
    public boolean login(String email, String pswd) {

        boolean valid = false;
        pswd = Hash.hashThis(pswd);
        String sentence = SQLSentences.emailPswd(email, pswd);
        try {
            HashMap<String, ArrayList<String>> data = sqlConnection.Query(sentence);
            if (!data.get("pswd").isEmpty()) {
                valid = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InMemoryDigitalWaiterPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }

    @Override
    public Set<Restaurant> getAllRestaurants() {
        Set<Restaurant> set = new HashSet<>();
        String sentence = SQLSentences.all("restaurant");

        try {
            HashMap<String, ArrayList<String>> restaurants = sqlConnection.Query(sentence);
            int p = 0;
            for (String i : restaurants.get("id")) {
                Restaurant us = new Restaurant(i, restaurants.get("name").get(p), restaurants.get("address").get(p), restaurants.get("phonenumber").get(p));
                set.add(us);
                p += 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(InMemoryDigitalWaiterPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }

    @Override
    public Set<Menu> getAllMenus() {
        Set<Menu> set = new HashSet<>();
        String sentence = SQLSentences.all("menu");

        try {
            HashMap<String, ArrayList<String>> menus = sqlConnection.Query(sentence);
            int p = 0;
            for (String i : menus.get("id")) {
                Menu us = new Menu(i, menus.get("name").get(p), menus.get("price").get(p), menus.get("calories").get(p));
                set.add(us);
                p += 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InMemoryDigitalWaiterPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }

    @Override
    public Set<Plato> getAllPlatos() {
        Set<Plato> set = new HashSet<>();
        String sentence = SQLSentences.all("plato");

        try {
            HashMap<String, ArrayList<String>> platos = sqlConnection.Query(sentence);
            int p = 0;
            for (String i : platos.get("id")) {
                Plato us = new Plato(i, platos.get("name").get(p), platos.get("price").get(p), platos.get("calories").get(p));
                set.add(us);
                p += 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InMemoryDigitalWaiterPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }

    @Override
    public Set<Ingredient> getAllIngredients() {
        Set<Ingredient> set = new HashSet<>();
        String sentence = SQLSentences.all("ingredient");

        try {
            HashMap<String, ArrayList<String>> ingredients = sqlConnection.Query(sentence);
            int p = 0;
            for (String i : ingredients.get("id")) {
                Ingredient us = new Ingredient(i, ingredients.get("name").get(p), ingredients.get("weight").get(p));
                set.add(us);
                p += 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InMemoryDigitalWaiterPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return set;
    }

}
