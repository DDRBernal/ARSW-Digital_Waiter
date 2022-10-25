package edu.eci.arsw.digital_waiter.persistence.impl;

import edu.eci.arsw.digital_waiter.model.Admin;
import edu.eci.arsw.digital_waiter.model.Client;
import edu.eci.arsw.digital_waiter.model.Ingredient;
import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Restaurant;
import edu.eci.arsw.digital_waiter.model.Table;
import edu.eci.arsw.digital_waiter.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author juane
 */
@Component
@Qualifier("MakerModel")
public class MakeModelImpl implements MakeModel {
    
    @Override
    public Set<User> makeUser(HashMap<String, ArrayList<String>> users) {
        Set<User> set = new HashSet<>();
        int p = 0;
        for (String i : users.get("isadmin")) {
            User us = null;
            if ("f".equals(i)) {
                us = new Client(users.get("id").get(p), users.get("name").get(p), users.get("phonenumber").get(p), users.get("email").get(p), users.get("age").get(p), users.get("pswd").get(p));
            } else if ("t".equals(i)) {
                us = new Admin(users.get("id").get(p), users.get("name").get(p), users.get("phonenumber").get(p), users.get("email").get(p), users.get("age").get(p), users.get("pswd").get(p));
            }
            set.add(us);
            p += 1;
        }
        return set;
    }
    @Override
    public Set<Restaurant> makeRestaurant(HashMap<String, ArrayList<String>> restaurants) {
        Set<Restaurant> set = new HashSet<>();
        int p = 0;
        for (String i : restaurants.get("id")) {
            Restaurant us = new Restaurant(i, restaurants.get("name").get(p), restaurants.get("address").get(p), restaurants.get("phonenumber").get(p));
            set.add(us);
            p += 1;
        }
        return set;
    }
    @Override
    public Set<Ingredient> makeIngredient(HashMap<String, ArrayList<String>> ingredients) {
        Set<Ingredient> set = new HashSet<>();

        int p = 0;
        for (String i : ingredients.get("id")) {
            Ingredient us = new Ingredient(i, ingredients.get("name").get(p), ingredients.get("weight").get(p));
            set.add(us);
            p += 1;
        }
        return set;
    }
    @Override
    public Set<Menu> makeMenu(HashMap<String, ArrayList<String>> menus) {
        Set<Menu> set = new HashSet<>();

        int p = 0;
        for (String i : menus.get("id")) {
            Menu us = new Menu(i, menus.get("name").get(p), menus.get("price").get(p), menus.get("calories").get(p),menus.get("idrestaurant").get(p));
            set.add(us);
            p += 1;
        }
        return set;

    }
    @Override
    public Set<Plato> makePlato(HashMap<String, ArrayList<String>> platos) {
        Set<Plato> set = new HashSet<>();

        int p = 0;
        for (String i : platos.get("id")) {
            Plato us = new Plato(i, platos.get("name").get(p), platos.get("price").get(p), platos.get("calories").get(p),platos.get("idrestaurant").get(p));
            set.add(us);
            p += 1;
        }
        return set;
    }

    @Override
    public Set<Table> makeTable(HashMap<String, ArrayList<String>> tables) {
        Set<Table> set = new HashSet<>();

        int p = 0;
        for (String i : tables.get("id")) {
            boolean dis;
            dis = !"f".equals(tables.get("disponibility").get(p));
            Table us = new Table(tables.get("name").get(p), i, tables.get("zone").get(p), dis,tables.get("idrestaurant").get(p));
            set.add(us);
            p += 1;
        }
        return set;
    }
}
