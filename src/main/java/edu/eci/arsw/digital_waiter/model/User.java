/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.model;

/**
 *
 * @author Andres - David - Juan
 */
public abstract class User {
   
    private String name;

    public User(String name) {
        this.name = name;
    }    

    public abstract void rol();

    public String getName() {
        return name;
    }
}
