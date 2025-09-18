package com.berkeposlu.javautils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Utility class for common string operations.
 * 
 * @author Berke Poslu
 * @version 1.0.0
 */
public final class StringUtils {

    private StringUtils() {
        // Utility class - prevent instantiation
    }

    /**
     * Checks if a string is null or empty.
     *
     * @param str the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Checks if a string is not null and not empty.
     *
     * @param str the string to check
     * @return true if the string is not null and not empty, false otherwise
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * Checks if a string is null, empty, or contains only whitespace characters.
     *
     * @param str the string to check
     * @return true if the string is blank, false otherwise
     */
    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Checks if a string is not blank.
     *
     * @param str the string to check
     * @return true if the string is not blank, false otherwise
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * Capitalizes the first letter of a string.
     *
     * @param str the string to capitalize
     * @return the capitalized string, or null if input is null
     */
    public static String capitalize(String str) {
        if (isEmpty(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    /**
     * Reverses a string.
     *
     * @param str the string to reverse
     * @return the reversed string, or null if input is null
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Counts the number of occurrences of a substring in a string.
     *
     * @param str the string to search in
     * @param substring the substring to count
     * @return the number of occurrences
     */
    public static int countOccurrences(String str, String substring) {
        if (isEmpty(str) || isEmpty(substring)) {
            return 0;
        }
        
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    /**
     * Converts a string to camelCase.
     *
     * @param str the string to convert
     * @return the camelCase string
     */
    public static String toCamelCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        
        String[] words = str.split("[\\s_-]+");
        if (words.length == 0) {
            return str.toLowerCase();
        }
        
        StringBuilder result = new StringBuilder(words[0].toLowerCase());
        for (int i = 1; i < words.length; i++) {
            result.append(capitalize(words[i]));
        }
        return result.toString();
    }

    /**
     * Joins an array of strings with a delimiter.
     *
     * @param delimiter the delimiter to use
     * @param elements the strings to join
     * @return the joined string
     */
    public static String join(String delimiter, String... elements) {
        if (elements == null || elements.length == 0) {
            return "";
        }
        return Arrays.stream(elements)
                .collect(Collectors.joining(delimiter));
    }

    /**
     * Truncates a string to a maximum length and adds ellipsis if necessary.
     *
     * @param str the string to truncate
     * @param maxLength the maximum length
     * @return the truncated string
     */
    public static String truncate(String str, int maxLength) {
        if (str == null || str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }
}
