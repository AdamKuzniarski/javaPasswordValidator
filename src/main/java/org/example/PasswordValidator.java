package org.example;

public class PasswordValidator {
        private static final int DEFAULT_MIN_LENGTH = 8;
        private static final String DEFAULT_ALLOWED_SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{}|;':\"<>,.?/";
        private static final String[] COMMON_PASSWORDS = {
                "password", "123456", "123456789", "qwerty", "abc123",
                "football", "monkey", "letmein", "111111", "welcome"
        };

        private PasswordValidator(){}

        public static boolean hasMinLength(String password, int min){
            if(password == null) return false;

            return password.length() >= min;
        }
        public static boolean containsDigit(String password){return false;}
        public static boolean containsUpperAndLowerCase(String password){return false;}
        public static boolean isCommonPassword(String password){return false;}

        public static boolean containsSpecialCharacter(String password, String allowed){return false;}
        public static boolean isValid(String password){return false;}

    }

