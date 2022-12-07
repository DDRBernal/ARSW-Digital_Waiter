
package edu.eci.arsw.digital_waiter.persistence.maker;

import edu.eci.arsw.digital_waiter.model.Ingredient;
import edu.eci.arsw.digital_waiter.model.Menu;
import edu.eci.arsw.digital_waiter.model.Plato;
import edu.eci.arsw.digital_waiter.model.Restaurant;
import edu.eci.arsw.digital_waiter.model.Table;
import edu.eci.arsw.digital_waiter.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Interfaz del componente makemodel de digitalwaiter
 * @author juane
 */
public interface MakeModel {
    public Set<User> makeUser(HashMap<String, ArrayList<String>> users);
    public Set<Restaurant> makeRestaurant(HashMap<String, ArrayList<String>> restaurants);
    public Set<Ingredient> makeIngredient(HashMap<String, ArrayList<String>> ingredients);
    public Set<Menu> makeMenu(HashMap<String, ArrayList<String>> menus);
    public Set<Plato> makePlato(HashMap<String, ArrayList<String>> platos);
    public Set<Table> makeTable(HashMap<String, ArrayList<String>> tables);
}
