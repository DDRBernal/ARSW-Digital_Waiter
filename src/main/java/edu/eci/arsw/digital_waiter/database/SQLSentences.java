
package edu.eci.arsw.digital_waiter.database;

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
    
}
