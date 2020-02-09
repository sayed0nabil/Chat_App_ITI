package org.example.utilies;

import java.util.regex.Pattern;

public class Validation {

    public static boolean validatePhoneNumber(String phoneNumber){
        return Pattern.matches("01(0|1|2|5)[0-9]{8}", phoneNumber);
    }
    /////Aya/////////////
    public static boolean validateEmail(String email){
        return Pattern.matches("[a-zA-Z_0-9._%+-]+@[a-zA-Z_0-9.-]+\\.[a-zA-Z]{2,}",email);
    }
    public static boolean validatePassword(String password){
        return Pattern.matches("(?=.*\\d)(?=.*[a-zA-Z]).{4,8}",password);
    }
    public static boolean validateConfiermedPassword(String password,String confirmedpassword){
        return confirmedpassword.equals(password)? true: false ;
    }
    ///////////end///////////////
}
