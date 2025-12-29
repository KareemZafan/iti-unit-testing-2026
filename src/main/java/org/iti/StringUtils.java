package org.iti;

public class StringUtils {

    public boolean isPalindromeString (String str){
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}
