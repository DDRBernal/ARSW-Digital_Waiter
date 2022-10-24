/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.controllers;

import edu.eci.arsw.digital_waiter.model.Client;
import edu.eci.arsw.digital_waiter.model.User;
import edu.eci.arsw.digital_waiter.services.DigitalWaiterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistenceException;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterNotFoundException;

/**
 *
 * @author Andres - David - Juan
 */

@RestController
@RequestMapping(value = "/dg")
public class DigitalWaiterServicesAPIController {
    @Autowired
    DigitalWaiterServices digitalWaiterServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetResource() {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getAllUsers(), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/allIngredients")
    public ResponseEntity<?> getAllIngredients() {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getAllIngredients(), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/allUsers")
    public ResponseEntity<?> getAllSUers() {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getAllUsers(), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/allPlatos")
    public ResponseEntity<?> getAllSPlatos() {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getAllPlatos(), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/allRestaurants")
    public ResponseEntity<?> getAllRestaurants() {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getAllRestaurants(), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/allMenus")
    public ResponseEntity<?> getAllMenus() {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getAllMenus(), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/login/{email}/{pswd}")
    public ResponseEntity<?> login(@PathVariable("email") String email,@PathVariable("pswd") String pswd) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.login(email,pswd), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

//    @RequestMapping(method = RequestMethod.POST, value="/{name}")
//    public ResponseEntity<?> addNewUser(@PathVariable String name){
//        try {
//            User user = new Client(name, phonenumber, email, age, pswd);
//            digitalWaiterServices.addNewUser(user);
//            return new ResponseEntity<>(HttpStatus.ACCEPTED);
//        } catch (DigitalWaiterPersistenceException e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }


}

