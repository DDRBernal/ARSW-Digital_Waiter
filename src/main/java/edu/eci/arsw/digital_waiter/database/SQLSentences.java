
package edu.eci.arsw.digital_waiter.database;

import edu.eci.arsw.digital_waiter.login.Hash;

/**
 *
 * @author juane
 */
public class SQLSentences {
    
    public static String all(String param){
        return "SELECT * FROM "+ param +";" ;
    }
    
    public static String emailPswd (String email, String pswd){
        return "SELECT email, pswd FROM usuario WHERE email = '"+email+"' AND pswd= '"+pswd+"';";
    }
    
    public static String userById(String id){
        return "SELECT * FROM usuario WHERE id = '"+id+"';";
    }
    
    public static String restaurantById(String id){
        return "SELECT * FROM restaurant WHERE id = '"+id+"';";
    }
    public static String menuById(String id){
        return "SELECT * FROM menu WHERE id = '"+id+"';";
    }
    public static String platoById(String id){
        return "SELECT * FROM plato WHERE id = '"+id+"';";
    }
    
    public static String ingredientById(String id){
        return "SELECT * FROM ingredient WHERE id = '"+id+"';";
    }
    
    public static String tableById(String id){
        return "SELECT * FROM mesa WHERE id = '"+id+"';";
    }
    
    public static String addNewUser(String name, String age, String phonenumber, String email, String password, boolean isRestaurant){
        return "INSERT INTO usuario (id , phonenumber, email, age, pswd, name, isadmin) VALUES ('"+Hash.hashThis(email+password)+"', '"+phonenumber+"', '"+email+"', '"+age+"', '"+password+"', '"+name+"', '"+isRestaurant+"');";
    }
}
