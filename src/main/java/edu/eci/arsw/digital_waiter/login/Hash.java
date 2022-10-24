package edu.eci.arsw.digital_waiter.login;

import java.util.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

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
