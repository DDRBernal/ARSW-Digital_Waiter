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
public interface User {  

    public abstract void rol();
    public String getId();
    
    public String getName();
    
    public String getPhonenumber();
    
    public String getEmail();
    
    public String getAge();
    
    public String getPswd();
    public void setId(String newId);
    
    public void setName(String newName);
    
    public void setPhonenumber(String newPhone);
    
    public void setEmail(String newEmail);
    
    public void setAge(String newAge);
    
    public void setPswd(String newPswd);
    
}
