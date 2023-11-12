package sn.edu.isepdiamniadio.dbe.GestionElection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordUtil {
    public static String genSHA512(String text){
        try {

            MessageDigest md=MessageDigest.getInstance("SHA-512");
            byte[] hash=md.digest(text.getBytes());
            String resultat= Base64.getEncoder().encodeToString(hash);
            return resultat;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
