package org.example;


public class PasswordValidator {
    private static final int DEFAULT_MIN_LENGTH = 8;
    private static final String DEFAULT_ALLOWED_SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/";
    private static final String[] COMMON_PASSWORDS = {
            "password", "123456", "123456789", "qwerty", "abc123",
            "football", "monkey", "letmein", "111111", "welcome"};

    private PasswordValidator() {
    }

    public static boolean hasMinLength(String password, int min) {
        if (password == null) return false;

        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {
        if (password == null) return false;

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

        char[] chars = password.toCharArray();
        for (char tempChar : chars) {
            if (Character.isUpperCase(tempChar)) hasUpper = true;
            if (Character.isLowerCase(tempChar)) hasLower = true;

            if (hasUpper && hasLower) return true;

        }
        return false;
    }

    public static boolean isCommonPassword(String password) {
        if (password == null) return false;

        String normalizedPassword = password.toLowerCase();
        for (String common : COMMON_PASSWORDS) {
            if (normalizedPassword.equals(common)) return true;
        }
        return false;
    }

    public static boolean containsSpecialCharacter(String password, String allowed) {
        if (password == null) return false;
        if (password == null || allowed.isEmpty()) return false;

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
    boolean base = hasMinLength(password, DEFAULT_MIN_LENGTH) && containsDigit(password) && containsUpperAndLowerCase(password) && !isCommonPassword(password);
    if (!base) return false;
    return  base;
    }
}
