package com.berkeposlu.javautils;

import java.util.regex.Pattern;

/**
 * Utility class for common validation operations.
 * 
 * @author Berke Poslu
 * @version 1.0.0
 */
public final class ValidationUtils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );

    private static final Pattern PHONE_PATTERN = Pattern.compile(
        "^[+]?[1-9]\\d{1,14}$"
    );

    private static final Pattern URL_PATTERN = Pattern.compile(
        "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"
    );

    private ValidationUtils() {
        // Utility class - prevent instantiation
    }

    /**
     * Validates an email address.
     *
     * @param email the email to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates a phone number (international format).
     *
     * @param phone the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    public static boolean isValidPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        // Remove common separators
        String cleanPhone = phone.replaceAll("[\\s()-]", "");
        return PHONE_PATTERN.matcher(cleanPhone).matches();
    }

    /**
     * Validates a URL.
     *
     * @param url the URL to validate
     * @return true if the URL is valid, false otherwise
     */
    public static boolean isValidUrl(String url) {
        if (StringUtils.isEmpty(url)) {
            return false;
        }
        return URL_PATTERN.matcher(url).matches();
    }

    /**
     * Validates that a string is numeric.
     *
     * @param str the string to validate
     * @return true if the string is numeric, false otherwise
     */
    public static boolean isNumeric(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates that a string is an integer.
     *
     * @param str the string to validate
     * @return true if the string is an integer, false otherwise
     */
    public static boolean isInteger(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates that a string contains only alphabetic characters.
     *
     * @param str the string to validate
     * @return true if the string is alphabetic, false otherwise
     */
    public static boolean isAlphabetic(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z]+$");
    }

    /**
     * Validates that a string contains only alphanumeric characters.
     *
     * @param str the string to validate
     * @return true if the string is alphanumeric, false otherwise
     */
    public static boolean isAlphanumeric(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]+$");
    }

    /**
     * Validates that a string has a minimum length.
     *
     * @param str the string to validate
     * @param minLength the minimum length required
     * @return true if the string meets the minimum length, false otherwise
     */
    public static boolean hasMinLength(String str, int minLength) {
        if (str == null) {
            return false;
        }
        return str.length() >= minLength;
    }

    /**
     * Validates that a string has a maximum length.
     *
     * @param str the string to validate
     * @param maxLength the maximum length allowed
     * @return true if the string is within the maximum length, false otherwise
     */
    public static boolean hasMaxLength(String str, int maxLength) {
        if (str == null) {
            return true; // null strings are considered valid for max length
        }
        return str.length() <= maxLength;
    }

    /**
     * Validates that a string length is within a range.
     *
     * @param str the string to validate
     * @param minLength the minimum length required
     * @param maxLength the maximum length allowed
     * @return true if the string length is within the range, false otherwise
     */
    public static boolean isLengthInRange(String str, int minLength, int maxLength) {
        return hasMinLength(str, minLength) && hasMaxLength(str, maxLength);
    }

    /**
     * Validates that a number is within a range.
     *
     * @param value the value to validate
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return true if the value is within the range, false otherwise
     */
    public static boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

    /**
     * Validates that an integer is within a range.
     *
     * @param value the value to validate
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return true if the value is within the range, false otherwise
     */
    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    /**
     * Validates that a value is not null.
     *
     * @param value the value to validate
     * @return true if the value is not null, false otherwise
     */
    public static boolean isNotNull(Object value) {
        return value != null;
    }

    /**
     * Validates that all values are not null.
     *
     * @param values the values to validate
     * @return true if all values are not null, false otherwise
     */
    public static boolean areAllNotNull(Object... values) {
        if (values == null) {
            return false;
        }
        for (Object value : values) {
            if (value == null) {
                return false;
            }
        }
        return true;
    }
}
