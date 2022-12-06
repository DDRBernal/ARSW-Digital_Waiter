/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.controllers;



import edu.eci.arsw.digital_waiter.services.DigitalWaiterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistenceException;


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
    @RequestMapping(method = RequestMethod.GET, value = "/userById/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getUserByID(id), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/imIAdmin/{email}")
    public ResponseEntity<?> imIAdmin(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.imIAdmin(email), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/user/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getUserByEmail(email), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/restaurant/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getRestaurantById(id), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/menu/{id}")
    public ResponseEntity<?> getMenuById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getMenuById(id), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/plato/{id}")
    public ResponseEntity<?> getPlatoById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getPlatoById(id), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/ingredient/{id}")
    public ResponseEntity<?> getIngredientById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getIngredientById(id), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/table/{id}")
    public ResponseEntity<?> getTableById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getTableById(id), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/allPlatos")
    public ResponseEntity<?> getAllPlatos() {
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
    
    @RequestMapping(method = RequestMethod.GET, value = "/allTables")
    public ResponseEntity<?> getAllTables() {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getAllTables(), HttpStatus.ACCEPTED);
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
    
    @RequestMapping(method = RequestMethod.GET, value = "/tablesByR/{restaurant}")
    public ResponseEntity<?> getTablesByRestaurant(@PathVariable("restaurant") String restaurantId) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getTablesByRestaurant(restaurantId), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/menusByR/{restaurant}")
    public ResponseEntity<?> getMenusByRestaurant(@PathVariable("restaurant") String restaurantId) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getMenusByRestaurant(restaurantId), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/platosByM/{menu}")
    public ResponseEntity<?> getPlatosByMenu(@PathVariable("menu") String menuId) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getPlatosByMenu(menuId), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/ingredientByP/{plato}")
    public ResponseEntity<?> getInredientByPlato(@PathVariable("plato") String platoId) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getInredientByPlato(platoId), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/platosByR/{restaurant}")
    public ResponseEntity<?> getPlatosByrestaurant(@PathVariable("restaurant") String restaurantId) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getPlatosByrestaurant(restaurantId), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/restaurantByU/{user}")
    public ResponseEntity<?> getRestaurantByUser(@PathVariable("user") String userId) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getRestaurantByUser(userId), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value="/addUser/{name}/{age}/{phonenumber}/{email}/{password}/{isRestaurant}")
    public ResponseEntity<?> addNewUser(@PathVariable String name, @PathVariable String age, @PathVariable String phonenumber, @PathVariable String email, @PathVariable String password, @PathVariable boolean isRestaurant){
        try {
            digitalWaiterServices.addNewUser( name, age, phonenumber, email,  password, isRestaurant);           
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/addRestaurant/{name}/{address}/{phonenumber}/{idusuario}")
    public ResponseEntity<?> addNewRestaurant(@PathVariable("name") String name, @PathVariable("address") String address, @PathVariable("phonenumber") String phonenumber, @PathVariable("idusuario") String idUsuario){
        try {
            digitalWaiterServices.addNewRestaurant( name, address, phonenumber, idUsuario);           
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/setTableByR/{id}/{restaurant}/{state}")
    public ResponseEntity<?> setTableDisponibilityByRestaurant(@PathVariable("id") String idTable, @PathVariable("restaurant") String idRestaurant, @PathVariable("state") boolean state){
        try {
            digitalWaiterServices.setTableDisponibilityByRestaurant( idTable, idRestaurant, state);           
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/addTableR/{name}/{restaurant}")
    public ResponseEntity<?> addNewteableRestaurant(@PathVariable("restaurant") String idRestaurant, @PathVariable("name") String name){
        try {
            digitalWaiterServices.addNewteableRestaurant( idRestaurant, name);           
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

