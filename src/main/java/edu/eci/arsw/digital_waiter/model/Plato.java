package edu.eci.arsw.digital_waiter.model;

/**
 *
 * @author juane
 */
public class Plato {
    private String id;
    private String name;
    private String price;
    private String calories;
    
    public Plato(String id, String name, String price, String calories){
        this.id = id;
        this.name = name;
        this.price = price;
        this.calories = calories;
    }
    public String getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPrice(){
        return this.price;
    }
    
    public String getCalories(){
        return this.calories;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setPrice(String newPrice){
        this.price = newPrice;
    }
    
    public void setCalories(String newCalories){
        this.calories = newCalories;
    }
    
    public void setId(String newId){
        this.id = newId;
    }
}
