/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.persistence.impl;

import edu.eci.arsw.digital_waiter.model.Client;
import edu.eci.arsw.digital_waiter.model.Restaurant;
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
 * @author Andres - David - Juan
 */
@Component
@Qualifier("inMemory")
public class InMemoryDigitalWaiterPersistence implements DigitalWaiterPersistence {

    private final Map<Tuple<String,String>,User> users=new HashMap<>();

    public InMemoryDigitalWaiterPersistence() {
        //load stub data
        User userTest1 = new Client("gyan");
        User userTest2 = new Restaurant("crepes_and_waffle");
        User userTest3 = new Client("andre");

        users.put(new Tuple<>("gyan","gyan"),userTest1);
        users.put(new Tuple<>("crepes_and_waffle","crepes_and_waffle"),userTest2);
        users.put(new Tuple<>("andre","andre"),userTest3);
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
        System.out.println(users.size());
        Set<User> set = new HashSet<>();
        for (Tuple<String,String> tuple : users.keySet()){
            User user = getUser(tuple.o1);
            set.add(user);
        }
        return set;
    }

}

