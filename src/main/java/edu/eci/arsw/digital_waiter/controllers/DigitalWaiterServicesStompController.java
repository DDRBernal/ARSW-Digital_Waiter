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
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import edu.eci.arsw.digital_waiter.persistence.DigitalWaiterPersistenceException;

import edu.eci.arsw.digital_waiter.model.Table;
import java.util.Set;

/**
 *
 * @author Andres - David - Juan
 */

@Controller
public class DigitalWaiterServicesStompController {
    
    @Autowired
    DigitalWaiterServices digitalWaiterServices;
    
    
    @MessageMapping("/tablesByR/")
    @SendTo("/stomp/table")
    public ResponseEntity<?> getTablesByRestaurant(String restaurantId) {
        try {
            return new ResponseEntity<>(digitalWaiterServices.getTablesByRestaurant(restaurantId), HttpStatus.ACCEPTED);
        } catch (DigitalWaiterPersistenceException ex){
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }


}

