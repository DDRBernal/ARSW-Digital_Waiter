package edu.eci.arsw.digital_waiter.database;

import edu.eci.arsw.digital_waiter.login.Hash;

/**
 * Sentencias SQL para las consultas y persistencia de datos en la bases de datos
 * @author juane
 */
public class SQLSentences {

    public static String all(String param) {
        return "SELECT * FROM " + param + ";";
    }

    public static String emailPswd(String email, String pswd) {
        return "SELECT email, pswd FROM usuario WHERE email = '" + email + "' AND pswd= '" + pswd + "';";
    }

    public static String userById(String id) {
        return "SELECT * FROM usuario WHERE id = '" + id + "';";
    }

    public static String restaurantById(String id) {
        return "SELECT * FROM restaurant WHERE id = '" + id + "';";
    }

    public static String menuById(String id) {
        return "SELECT * FROM menu WHERE id = '" + id + "';";
    }

    public static String platoById(String id) {
        return "SELECT * FROM plato WHERE id = '" + id + "';";
    }

    public static String ingredientById(String id) {
        return "SELECT * FROM ingredient WHERE id = '" + id + "';";
    }

    public static String tableById(String id) {
        return "SELECT * FROM mesa WHERE id = '" + id + "';";
    }

    public static String addNewUser(String name, String age, String phonenumber, String email, String password, boolean isRestaurant) {
        return "INSERT INTO usuario (id , phonenumber, email, age, pswd, name, isadmin) VALUES ('" + Hash.hashThis(email + password) + "', '" + phonenumber + "', '" + email + "', '" + age + "', '" + password + "', '" + name + "', '" + isRestaurant + "');";
    }

    public static String addRestaurant(String name, String address, String phonenumber, String idusuario) {
        return "INSERT INTO restaurant (name, address, phonenumber, idusuario) VALUES ('" + name + "', '" + address + "' ,'" + phonenumber + "' ,'" + idusuario + "');";
    }
    
    public static String addTableRestaurant(String id, String zone, boolean disponibility, String name, String idrestaurant) {
        return "INSERT INTO mesa (id, zone, disponibility, name, idrestaurant) VALUES ('" + id + "', '" + zone + "' ,'" + disponibility + "' ,'" + name + "' ,'" + idrestaurant +"');";
    }

    public static String setTableDisponibilityByRestaurant(String idRestaurant, String idTable, boolean state) {
        return "UPDATE mesa SET disponibility = '" + state + "' WHERE id = '" + idTable + "' AND idrestaurant = '" + idRestaurant + "';";
    }

    public static String tablesByRestaurant(String idRestaurant) {
        return "SELECT * FROM mesa WHERE idrestaurant = '" + idRestaurant + "';";
    }

    public static String menusByRestaurant(String idRestaurant) {
        return "SELECT * FROM menu WHERE idrestaurant = '" + idRestaurant + "';";
    }

    public static String platosByRestaurant(String idRestaurant) {
        return "SELECT * FROM plato WHERE idrestaurant = '" + idRestaurant + "';";
    }

    public static String restaurantsByUser(String idUser) {
        return "SELECT * FROM restaurant WHERE idusuario = '" + idUser + "';";
    }

    public static String platosByMenu(String idMenu) {
        return "select plato.id, plato.\"name\", plato.price, plato.calories, plato.idrestaurant  from plato join menuplato on menuplato.idplato = plato.id  join menu on menu.id = menuplato.idmenu  where menu.id  = '" + idMenu + "';";
    }

    public static String ingredentByPlato(String idPlato) {
        return "select ingredient.id, ingredient.\"name\", ingredient.weight  from ingredient join platoingrediente on ingredient.id = platoingrediente.idingredient  join plato on plato.id = platoingrediente.idplato  where plato.id  = '" + idPlato + "';";
    }

    public static String userByEmail(String email) {
        return "SELECT * FROM usuario WHERE email = '" + email + "';";
    }

}
