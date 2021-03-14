package dev.debride.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordCheckingUtil {

    public static boolean checkPass(String plainP, String hashP){
        if (BCrypt.checkpw(plainP, hashP)){
            System.out.println("The password matches.");
            return true;
        } else {
            System.out.println("The password does not match.");
            return false;
        }
    }

}
