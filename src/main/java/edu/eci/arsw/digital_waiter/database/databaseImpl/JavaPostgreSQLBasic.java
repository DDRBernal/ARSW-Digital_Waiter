package edu.eci.arsw.digital_waiter.database.databaseImpl;

import edu.eci.arsw.digital_waiter.database.JavaPostgreSQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SQLConnection")
public class JavaPostgreSQLBasic implements JavaPostgreSQL {

    private Connection connection;

    public JavaPostgreSQLBasic() {
        this.connection = connectDatabase();
    }

    /**
     * We establish the connection with the database digitalwaiter. Establecemos
     * la conexión con la base de datos digitalwaiter.
     *
     * @return
     */
    @Override
    public Connection connectDatabase() {
        Connection conn = null;
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }

            // Database connect
            // Conectamos con la base de datos
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://35.199.183.114:5432/digitalwaiter",
                    "postgres", "1^T023)f?u]=f\")d");

            boolean valid = conn.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        return conn;
    }

    /**
     * Method to connect to the database by passing parameters.
     *
     * @param host String host name or ip.
     * @param port String listening database port.
     * @param database String database name for the connection.
     * @param user String user name.
     * @param password String user password.
     */
    @Override
    public void connectDatabase(String host, String port, String database,
            String user, String password) {
        Connection connection = null;
        String url = "";
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }

            url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            // Database connect
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(
                    url,
                    user, password);
            connection.createStatement();
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error al conectar con la base de datos de PostgreSQL (" + url + "): " + sqle);
        }

    }

    @Override
    public HashMap<String, ArrayList<String>> Query(String sentence) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sentence);
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        HashMap<String, ArrayList<String>> table = new HashMap<>();
        ArrayList<String> namesColumns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            rs = stmt.executeQuery(sentence);
            ArrayList<String> values = new ArrayList<>();
            String nameColumn = rsmd.getColumnName(i);
            namesColumns.add(nameColumn);
            while (rs.next()) {
                String value = rs.getString(nameColumn);
                values.add(value);
            }
            table.put(nameColumn, values);
        }
        rs.close();
        stmt.close();
        return table;
    }

    @Override
    public void insertQuery(String sentence) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sentence);
        stmt.close();
    }
}
