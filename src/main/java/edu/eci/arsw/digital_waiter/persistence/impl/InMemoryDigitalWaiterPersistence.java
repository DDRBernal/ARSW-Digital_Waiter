/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.persistence.impl;

import edu.eci.arsw.digital_waiter.model.User;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
@Component
@Qualifier("inMemory")
public class InMemoryDigitalWaiterPersistence implements DigitalWaiterPersistence {

    private final Map<Tuple<String,String>,User> users=new HashMap<>();

    public InMemoryDigitalWaiterPersistence() {
        //load stub data
        // User userTest1 = new Client("test client");
    }    
    
    @Override
    public void saveUser(User user)  {
        if (users.containsKey(new Tuple<>(user.getName(),user.getName()))){
            //user already exists
        }
        else{
            users.put(new Tuple<>(user.getName(),user.getName()), user);
        }        
    }

    @Override
    public User getUser(String name) {
        return users.get(new Tuple<>(name, name));
    }

    @Override
    public Set<User> getAllUsers()  {
        Set<User> set = new HashSet<>();
        for (Tuple<String,String> tuple : users.keySet()){

        }
        return set;
    }

}

