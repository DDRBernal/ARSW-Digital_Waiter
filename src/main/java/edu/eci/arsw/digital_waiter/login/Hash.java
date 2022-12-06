package edu.eci.arsw.digital_waiter.login;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase que provee el servicio de generar un Hash dado una cadena tipo String, usando MD5
 * @author juane
 */
public class Hash {

    /**
     * Metodo que ejecuta la funcion hash dado una cadena String
     * @param str cadena a la cual se pasara por la funcion hash
     * @return String con el hash de la cadena ingresada
     */
    public static String hashThis(String str) {

        byte[] msg = str.getBytes();

        byte[] hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hash = md.digest(msg);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        StringBuilder strBuilder = new StringBuilder();
        for (byte b : hash) {
            strBuilder.append(String.format("%02x", b));
        }
        String strHash = strBuilder.toString();
        return strHash;
    }
}
