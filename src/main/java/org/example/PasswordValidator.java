package org.example;

import java.util.List;

public class PasswordValidator {
    private static final int DEFAULT_MIN_LENGTH = 8;
    private static final String DEFAULT_ALLOWED_SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/";
    private static final List<String> COMMON_PASSWORDS = List.of("password", "123456", "123456789", "qwerty", "abc123",
            "football", "monkey", "letmein", "111111", "welcome");

    private PasswordValidator() {
    }

    public static boolean hasMinLength(String password, int min) {
        if (password == null) {
            return false;
        }

        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {
        if (password == null) {
            return false;
        }

        char[] chars = password.toCharArray();// toCharArray macht aus einem String ein Array von chars
        for (char tempChar : chars) {
            if (Character.isDigit(tempChar)) return true;
        }
        return false;
    }

    public static boolean containsUpperAndLowerCase(String password) {
        if (password == null) return false;
        boolean hasUpper = false;
        boolean hasLower = false;

        return !password.toLowerCase().equals(password) || !password.toUpperCase().equals(password);

//        char[] chars = password.toCharArray();
//        for (char tempChar : chars) {
//            if (Character.isUpperCase(tempChar)) hasUpper = true;
//            if (Character.isLowerCase(tempChar)) hasLower = true;
//
//            if (hasUpper && hasLower) return true;
//
//        }
    }

    public static boolean isCommonPassword(String password) {
        if (password == null) return false;

        String normalizedPassword = password.toLowerCase().trim();
        return COMMON_PASSWORDS.contains(normalizedPassword);

//        for (String common : COMMON_PASSWORDS) {
//            if (normalizedPassword.equals(common)) return true;
//        }
//        return false;
    }


    /*

    containsSpecialCharacter("password123!", "!"); // returns true
    containsSpecialCharacter("password123", "!"); // returns false
    containsSpecialCharacter("password123!", ""); // returns true

     */

    public static boolean containsSpecialCharacter(String password, List<Character> allowed) {
        if (password == null) return false;
        if (allowed == null || allowed.isEmpty()) return true;

        char[] chars = password.toCharArray();
        for (char tempChar : chars) {
            if (allowed.contains(tempChar)) return true;
        }

        return false;
    }

    public static boolean containsSpecialCharacter(String password, String allowed) {
        if (password == null) return false;
        if (allowed == null || allowed.isEmpty()) return true;

        char[] chars = password.toCharArray();
        for (char tempChar : chars) {
            for (int i = 0; i < allowed.length(); i++) {
                if (tempChar == allowed.charAt(i)) return true;
            }
        }

        return false;
    }

    public static boolean isValid(String password) {
        if (password == null) return false;

        return hasMinLength(password, DEFAULT_MIN_LENGTH)
                && containsDigit(password)
                && containsUpperAndLowerCase(password)
                && !isCommonPassword(password)
                && containsSpecialCharacter(password, DEFAULT_ALLOWED_SPECIAL_CHARACTERS);
    }
}
