/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.digital_waiter.persistence;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Andres - David - Juan
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class DigitalWaiterNotFoundException extends Exception{


    public DigitalWaiterNotFoundException(String message){
        super(message);
    }

}
