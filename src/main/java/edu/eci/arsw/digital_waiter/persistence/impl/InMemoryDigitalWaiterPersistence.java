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

    private final Map<Tuple<String, String>, User> users = new HashMap<>();

    @Autowired
    JavaPostgreSQLBasic sqlConnection;

    @Override
    public void saveUser(User user) {
        if (users.containsKey(new Tuple<>(user.getName(), user.getName()))) {
            //user already exists
        } else {
            users.put(new Tuple<>(user.getName(), user.getName()), user);
        }
    }

    @Override
    public User getUser(String name) {
        return users.get(new Tuple<>(name, name));
    }

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
                    us = new Client(users.get("name").get(p), users.get("phonenumber").get(p), users.get("email").get(p), users.get("age").get(p), users.get("pswd").get(p));
                } else if ("t".equals(i)) {
                    us = new Restaurant(users.get("name").get(p), users.get("phonenumber").get(p), users.get("email").get(p), users.get("age").get(p), users.get("pswd").get(p));
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
            if (!data.get("pswd").isEmpty()){valid = true;}
            
        } catch (SQLException ex) {
            Logger.getLogger(InMemoryDigitalWaiterPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }

}
