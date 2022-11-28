package edu.eci.arsw.digital_waiter.persistence;

public class DigitalWaiterPersistenceException extends Exception{

    public static final String ERROR_SQL_CON = "Error en la consulta de la base de datos";
    public static final String ERROR_SQL_NOTFOUDN = "El elemento no se encuentra en la base de datos";
    public static final String ERROR_SQL_INSERT = "No se pudo insertar en la base de datos";
    public DigitalWaiterPersistenceException(String message){
        super(message);
    }
}
