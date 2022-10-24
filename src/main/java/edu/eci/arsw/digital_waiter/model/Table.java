
package edu.eci.arsw.digital_waiter.model;

/**
 *
 * @author juane
 */
public class Table {
    private String id;
    private String name;
    private String zone;
    private boolean disponibility;
    
    public Table(String name, String id, String zone, boolean disponibility){
        this.id = id;
        this.name = name;
        this.disponibility = disponibility;
        this.zone = zone;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String gatZone(){
        return this.zone;
    }
    
    public boolean getDisponibility(){
        return this.disponibility;
    }
    
    public void setId(String newId){
        this.id = newId;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setZone(String newZone){
        this.zone = newZone;
    }
    
    public void setDisponibility(boolean newDisponibility){
        this.disponibility = newDisponibility;
    }
}
