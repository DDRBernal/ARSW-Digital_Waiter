package edu.eci.arsw.digital_waiter.model;

/**
 *
 * @author juane
 */
public class Restaurant {

    private String id;
    private String name;
    private String address;
    private String phonenumber;
    
    
    public Restaurant(String id, String name, String address, String phonenumber){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
    }
    public String getName(){
        return this.name;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public String getPhonenumber(){
        return this.phonenumber;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setAddress(String newAddress){
        this.address = newAddress;
    }
    
    public void setPhonenumber(String newPhonenumber){
        this.phonenumber = newPhonenumber;
    }
}
