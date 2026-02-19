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
    void testIsValid_NoUpperCase_ReturnsFalse(){
        //Given
        String password ="abcdefg1";
        //When
        boolean actual = PasswordValidator.isValid(password);
        //Then
       assertFalse(actual);
    }
@Test
void testIsValid_CommonPassword_ReturnsFalse(){
    //Given
    String password = "password";
    //When
    boolean actual = PasswordValidator.isValid(password);
    //Then
    assertFalse(actual);
}

@Test
    void testIsValid_AllBaseRules_ReturnsTrue(){
    //Given
    String password = "Abcdefg1!";
    //When
    boolean actual = PasswordValidator.isValid(password);
    //Then
    assertTrue(actual);
}
}
