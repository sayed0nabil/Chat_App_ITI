package org.example.utilies;

import java.util.regex.Pattern;

public class Validation {

    public static boolean validatePhoneNumber(String phoneNumber){
        return Pattern.matches("01(0|1|2|5)[0-9]{8}", phoneNumber);
    }
}
