
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
    
    public static String tablesByRestaurant(String idRestaurant){
        return "select mesa.id, mesa.\"zone\", mesa.disponibility, mesa.\"name\"  from mesa join tablerestaurant on mesa.id = tablerestaurant.idtable join restaurant on tablerestaurant.idrestaurant = restaurant.id where restaurant.id = '"+idRestaurant+"';";
    }
    
    public static String menusByRestaurant(String idRestaurant){
        return "select menu.id, menu.\"name\", menu.price, menu.calories  from menu join restaurantmenu on restaurantmenu.idmenu = menu.id  join restaurant on restaurant.id = restaurantmenu.idrestaurant  where restaurant.id = '"+idRestaurant+"';";
    }
    
    public static String platosByMenu(String idMenu){
        return "select plato.id, plato.\"name\", plato.price, plato.calories  from plato join menuplato on menuplato.idplato = plato.id  join menu on menu.id = menuplato.idmenu  where menu.id  = '"+idMenu+"';";
    }
    
    public static String ingredentByPlato(String idPlato){
        return "select ingredient.id, ingredient.\"name\", ingredient.weight  from ingredient join platoingrediente on ingredient.id = platoingrediente.idingredient  join plato on plato.id = platoingrediente.idplato  where plato.id  = '"+idPlato+"';";
    }
    
}
