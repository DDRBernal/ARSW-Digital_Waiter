package edu.eci.arsw.digital_waiter.model;

/**
 *
 * @author juane
 */
public class Ingredient {
    private String id;
    private String name;
    private String weight;
    
    public Ingredient(String id, String name, String weight){
        this.id = id;
        this.name = name;
        this.weight = weight;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getWeight(){
        return this.weight;
    }
    
    public void setId(String newId){
        this.id = newId;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setWeight(String newWeight){
        this.weight = newWeight;
    }
}
