package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testHasMinLength_NullPassword_ReturnsFals() {
        //Given
        String password = null;
        int minLength = 8;

        boolean expectedResult = false;
        //When
        boolean actual = PasswordValidator.hasMinLength(password, minLength);
        //Then
        //assertEquals(expectedResult, actual);
        assertFalse(actual);
    }

    @Test
    void testHasMinLength_TooShortPassword_ReturnsFalse() {
        //Given
        String password = "1234567";
        int minLength = 8;

        boolean expectedResult = false;
        //When
        boolean actual = PasswordValidator.hasMinLength(password, minLength);

        //Then
        assertEquals(expectedResult, actual);
    }

    @Test
    void testIsValid_TooShortPassword_ReturnsFalse() {
        //Given
        String password = "Abc0!";
        boolean expectedResult = false;

        //When
        boolean actual = PasswordValidator.isValid(password);

        //Then
        assertEquals(expectedResult, actual);
    }

    @Test
    void testIsValid_NoDigit_ReturnsFalse() {
        //Given
        String password = "Abcdefg";

        boolean expectedResult = false;
        //When
        boolean actual = PasswordValidator.isValid(password);

        //Then
        assertEquals(expectedResult, actual);
    }

    @Test
    void containsDigit() {
        //Given
        String password = "abcd1235";
    }

    @org.junit.jupiter.api.Test
    void containsUpperAndLowerCase() {
    }

    @org.junit.jupiter.api.Test
    void isCommonPassword() {
    }

    @org.junit.jupiter.api.Test
    void containsSpecialCharacter() {
    }

    @org.junit.jupiter.api.Test
    void isValid() {
    }
}
