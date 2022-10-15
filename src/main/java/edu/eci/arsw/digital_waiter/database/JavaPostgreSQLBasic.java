package edu.eci.arsw.digital_waiter.database;
import java.sql.*;

public class JavaPostgreSQLBasic {
    /**
     * We establish the connection with the database digitalwaiter.
     * Establecemos la conexión con la base de datos digitalwaiter.
     *
     * @return
     */
    public Connection connectDatabase() {
        Connection connection = null;
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
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://35.199.183.114:5432/digitalwaiter",
                    "postgres", "1^T023)f?u]=f\")d");

            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        return connection;
    }

    /**
     * Method to connect to the database by passing parameters.
     * Método para establecer la conexión a la base de datos mediante el paso de parámetros.
     *
     * @param host String host name or ip. Nombre del host o ip.
     * @param port String listening database port. Puerto en el que escucha la base de datos.
     * @param database String database name for the connection. Nombre de la base de datos para la conexión.
     * @param user String user name. Nombre de usuario.
     * @param password String user password. Password del usuario.
     */
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


    public void Query(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery( "select id from client;" );
        while ( rs.next() ) {
            String id = rs.getString("id");
//            String b = rs.getString("phonenomber");
//            String c = rs.getString("email");
//            String d = rs.getString("age");
//            String e = rs.getString("pswd");
            System.out.println( "id: "+ id);

        }
        rs.close();stmt.close();connection.close();
    }



    /**
     * Testing Java PostgreSQL connection with host and port
     * Probando la conexión en Java a PostgreSQL especificando el host y el puerto.
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        JavaPostgreSQLBasic javaPostgreSQLBasic = new JavaPostgreSQLBasic();
        Connection connection = javaPostgreSQLBasic.connectDatabase();
        javaPostgreSQLBasic.Query(connection);
        String host = "35.199.183.114";
        String port = "5432";
        String database = "digitalwaiter";
        String user = "postgres";
        String password = "1^T023)f?u]=f\")d";
        javaPostgreSQLBasic.connectDatabase(host,port,database,user,password);
    }
}