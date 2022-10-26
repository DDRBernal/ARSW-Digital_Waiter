
package edu.eci.arsw.digital_waiter.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juane
 */
public interface JavaPostgreSQL {
    public void connectDatabase(String host, String port, String database,String user, String password);
    public Connection connectDatabase();
    public HashMap<String, ArrayList<String>> Query(String sentence) throws SQLException;
    public void insertQuery(String sentence) throws SQLException;
}
