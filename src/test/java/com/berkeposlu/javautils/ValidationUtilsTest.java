package com.berkeposlu.javautils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for ValidationUtils class.
 */
class ValidationUtilsTest {

    @Test
    void testIsValidEmail() {
        assertTrue(ValidationUtils.isValidEmail("test@example.com"));
        assertTrue(ValidationUtils.isValidEmail("user.name@domain.co.uk"));
        assertTrue(ValidationUtils.isValidEmail("test+tag@example.org"));
        
        assertFalse(ValidationUtils.isValidEmail(null));
        assertFalse(ValidationUtils.isValidEmail(""));
        assertFalse(ValidationUtils.isValidEmail("invalid-email"));
        assertFalse(ValidationUtils.isValidEmail("@example.com"));
        assertFalse(ValidationUtils.isValidEmail("test@"));
        assertFalse(ValidationUtils.isValidEmail("test.example.com"));
    }

    @Test
    void testIsValidPhone() {
        assertTrue(ValidationUtils.isValidPhone("+1234567890"));
        assertTrue(ValidationUtils.isValidPhone("1234567890"));
        assertTrue(ValidationUtils.isValidPhone("+49 30 12345678"));
        assertTrue(ValidationUtils.isValidPhone("(123) 456-7890"));
        
        assertFalse(ValidationUtils.isValidPhone(null));
        assertFalse(ValidationUtils.isValidPhone(""));
        assertFalse(ValidationUtils.isValidPhone("123"));
        assertFalse(ValidationUtils.isValidPhone("abc123"));
        assertFalse(ValidationUtils.isValidPhone("+"));
    }

    @Test
    void testIsValidUrl() {
        assertTrue(ValidationUtils.isValidUrl("https://www.example.com"));
        assertTrue(ValidationUtils.isValidUrl("http://example.com"));
        assertTrue(ValidationUtils.isValidUrl("ftp://files.example.com"));
        assertTrue(ValidationUtils.isValidUrl("https://example.com/path?param=value"));
        
        assertFalse(ValidationUtils.isValidUrl(null));
        assertFalse(ValidationUtils.isValidUrl(""));
        assertFalse(ValidationUtils.isValidUrl("not-a-url"));
        assertFalse(ValidationUtils.isValidUrl("www.example.com"));
        assertFalse(ValidationUtils.isValidUrl("mailto:test@example.com"));
    }

    @Test
    void testIsNumeric() {
        assertTrue(ValidationUtils.isNumeric("123"));
        assertTrue(ValidationUtils.isNumeric("123.45"));
        assertTrue(ValidationUtils.isNumeric("-123"));
        assertTrue(ValidationUtils.isNumeric("0"));
        assertTrue(ValidationUtils.isNumeric("3.14159"));
        
        assertFalse(ValidationUtils.isNumeric(null));
        assertFalse(ValidationUtils.isNumeric(""));
        assertFalse(ValidationUtils.isNumeric("abc"));
        assertFalse(ValidationUtils.isNumeric("12a3"));
        assertFalse(ValidationUtils.isNumeric("12.34.56"));
    }

    @Test
    void testIsInteger() {
        assertTrue(ValidationUtils.isInteger("123"));
        assertTrue(ValidationUtils.isInteger("-123"));
        assertTrue(ValidationUtils.isInteger("0"));
        
        assertFalse(ValidationUtils.isInteger(null));
        assertFalse(ValidationUtils.isInteger(""));
        assertFalse(ValidationUtils.isInteger("123.45"));
        assertFalse(ValidationUtils.isInteger("abc"));
        assertFalse(ValidationUtils.isInteger("12a3"));
    }

    @Test
    void testIsAlphabetic() {
        assertTrue(ValidationUtils.isAlphabetic("abc"));
        assertTrue(ValidationUtils.isAlphabetic("ABC"));
        assertTrue(ValidationUtils.isAlphabetic("AbC"));
        
        assertFalse(ValidationUtils.isAlphabetic(null));
        assertFalse(ValidationUtils.isAlphabetic(""));
        assertFalse(ValidationUtils.isAlphabetic("abc123"));
        assertFalse(ValidationUtils.isAlphabetic("abc def"));
        assertFalse(ValidationUtils.isAlphabetic("abc-def"));
    }

    @Test
    void testIsAlphanumeric() {
        assertTrue(ValidationUtils.isAlphanumeric("abc123"));
        assertTrue(ValidationUtils.isAlphanumeric("ABC123"));
        assertTrue(ValidationUtils.isAlphanumeric("test"));
        assertTrue(ValidationUtils.isAlphanumeric("123"));
        
        assertFalse(ValidationUtils.isAlphanumeric(null));
        assertFalse(ValidationUtils.isAlphanumeric(""));
        assertFalse(ValidationUtils.isAlphanumeric("abc def"));
        assertFalse(ValidationUtils.isAlphanumeric("abc-123"));
        assertFalse(ValidationUtils.isAlphanumeric("abc@123"));
    }

    @Test
    void testHasMinLength() {
        assertTrue(ValidationUtils.hasMinLength("hello", 5));
        assertTrue(ValidationUtils.hasMinLength("hello", 3));
        assertTrue(ValidationUtils.hasMinLength("", 0));
        
        assertFalse(ValidationUtils.hasMinLength(null, 1));
        assertFalse(ValidationUtils.hasMinLength("hello", 10));
        assertFalse(ValidationUtils.hasMinLength("", 1));
    }

    @Test
    void testHasMaxLength() {
        assertTrue(ValidationUtils.hasMaxLength("hello", 10));
        assertTrue(ValidationUtils.hasMaxLength("hello", 5));
        assertTrue(ValidationUtils.hasMaxLength("", 5));
        assertTrue(ValidationUtils.hasMaxLength(null, 5));
        
        assertFalse(ValidationUtils.hasMaxLength("hello", 3));
    }

    @Test
    void testIsLengthInRange() {
        assertTrue(ValidationUtils.isLengthInRange("hello", 3, 10));
        assertTrue(ValidationUtils.isLengthInRange("hello", 5, 5));
        assertTrue(ValidationUtils.isLengthInRange("", 0, 5));
        
        assertFalse(ValidationUtils.isLengthInRange("hello", 10, 15));
        assertFalse(ValidationUtils.isLengthInRange("hello", 1, 3));
        assertFalse(ValidationUtils.isLengthInRange(null, 1, 5));
    }

    @Test
    void testIsInRangeDouble() {
        assertTrue(ValidationUtils.isInRange(5.0, 1.0, 10.0));
        assertTrue(ValidationUtils.isInRange(1.0, 1.0, 10.0));
        assertTrue(ValidationUtils.isInRange(10.0, 1.0, 10.0));
        
        assertFalse(ValidationUtils.isInRange(0.5, 1.0, 10.0));
        assertFalse(ValidationUtils.isInRange(15.0, 1.0, 10.0));
    }

    @Test
    void testIsInRangeInt() {
        assertTrue(ValidationUtils.isInRange(5, 1, 10));
        assertTrue(ValidationUtils.isInRange(1, 1, 10));
        assertTrue(ValidationUtils.isInRange(10, 1, 10));
        
        assertFalse(ValidationUtils.isInRange(0, 1, 10));
        assertFalse(ValidationUtils.isInRange(15, 1, 10));
    }

    @Test
    void testIsNotNull() {
        assertTrue(ValidationUtils.isNotNull("hello"));
        assertTrue(ValidationUtils.isNotNull(123));
        assertTrue(ValidationUtils.isNotNull(""));
        
        assertFalse(ValidationUtils.isNotNull(null));
    }

    @Test
    void testAreAllNotNull() {
        assertTrue(ValidationUtils.areAllNotNull("hello", 123, "world"));
        assertTrue(ValidationUtils.areAllNotNull("hello"));
        assertTrue(ValidationUtils.areAllNotNull());
        
        assertFalse(ValidationUtils.areAllNotNull(null));
        assertFalse(ValidationUtils.areAllNotNull("hello", null, "world"));
        assertFalse(ValidationUtils.areAllNotNull("hello", null));
    }
}
