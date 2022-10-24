
package edu.eci.arsw.digital_waiter.persistence;

import edu.eci.arsw.digital_waiter.model.User;
import java.util.Set;

/**
 *
 * @author Andres - David - Juan
 */
public interface DigitalWaiterPersistence {
    
    /**
     * 
     * @param user the new user
     *   or any other low-level persistence error occurs.
     */
    public void saveUser(User user) ;
    
    /**
     *
     * @return the user of the given name
     */
    public User getUser(String name);

    Set<User> getAllUsers() ;
    
    public boolean login (String email, String pswd);
    
}
