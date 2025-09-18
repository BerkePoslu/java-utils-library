package com.berkeposlu.javautils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for StringUtils class.
 */
class StringUtilsTest {

    @Test
    void testIsEmpty() {
        assertTrue(StringUtils.isEmpty(null));
        assertTrue(StringUtils.isEmpty(""));
        assertFalse(StringUtils.isEmpty(" "));
        assertFalse(StringUtils.isEmpty("hello"));
    }

    @Test
    void testIsNotEmpty() {
        assertFalse(StringUtils.isNotEmpty(null));
        assertFalse(StringUtils.isNotEmpty(""));
        assertTrue(StringUtils.isNotEmpty(" "));
        assertTrue(StringUtils.isNotEmpty("hello"));
    }

    @Test
    void testIsBlank() {
        assertTrue(StringUtils.isBlank(null));
        assertTrue(StringUtils.isBlank(""));
        assertTrue(StringUtils.isBlank(" "));
        assertTrue(StringUtils.isBlank("   "));
        assertFalse(StringUtils.isBlank("hello"));
        assertFalse(StringUtils.isBlank(" hello "));
    }

    @Test
    void testIsNotBlank() {
        assertFalse(StringUtils.isNotBlank(null));
        assertFalse(StringUtils.isNotBlank(""));
        assertFalse(StringUtils.isNotBlank(" "));
        assertFalse(StringUtils.isNotBlank("   "));
        assertTrue(StringUtils.isNotBlank("hello"));
        assertTrue(StringUtils.isNotBlank(" hello "));
    }

    @Test
    void testCapitalize() {
        assertNull(StringUtils.capitalize(null));
        assertEquals("", StringUtils.capitalize(""));
        assertEquals("Hello", StringUtils.capitalize("hello"));
        assertEquals("Hello", StringUtils.capitalize("HELLO"));
        assertEquals("Hello world", StringUtils.capitalize("hello world"));
        assertEquals("H", StringUtils.capitalize("h"));
    }

    @Test
    void testReverse() {
        assertNull(StringUtils.reverse(null));
        assertEquals("", StringUtils.reverse(""));
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("dlrow", StringUtils.reverse("world"));
        assertEquals("a", StringUtils.reverse("a"));
    }

    @Test
    void testCountOccurrences() {
        assertEquals(0, StringUtils.countOccurrences(null, "a"));
        assertEquals(0, StringUtils.countOccurrences("hello", null));
        assertEquals(0, StringUtils.countOccurrences("", "a"));
        assertEquals(2, StringUtils.countOccurrences("hello world", "l"));
        assertEquals(1, StringUtils.countOccurrences("hello world", "world"));
        assertEquals(0, StringUtils.countOccurrences("hello", "xyz"));
        assertEquals(3, StringUtils.countOccurrences("aaa", "a"));
        assertEquals(1, StringUtils.countOccurrences("aaa", "aa"));
    }

    @Test
    void testToCamelCase() {
        assertNull(StringUtils.toCamelCase(null));
        assertEquals("", StringUtils.toCamelCase(""));
        assertEquals("hello", StringUtils.toCamelCase("hello"));
        assertEquals("helloWorld", StringUtils.toCamelCase("hello world"));
        assertEquals("helloWorldTest", StringUtils.toCamelCase("hello-world_test"));
        assertEquals("test", StringUtils.toCamelCase("TEST"));
        assertEquals("camelCase", StringUtils.toCamelCase("camel_case"));
    }

    @Test
    void testJoin() {
        assertEquals("", StringUtils.join(","));
        assertEquals("", StringUtils.join(",", (String[]) null));
        assertEquals("a", StringUtils.join(",", "a"));
        assertEquals("a,b,c", StringUtils.join(",", "a", "b", "c"));
        assertEquals("a-b-c", StringUtils.join("-", "a", "b", "c"));
        assertEquals("abc", StringUtils.join("", "a", "b", "c"));
    }

    @Test
    void testTruncate() {
        assertNull(StringUtils.truncate(null, 5));
        assertEquals("hello", StringUtils.truncate("hello", 10));
        assertEquals("hello", StringUtils.truncate("hello", 5));
        assertEquals("he...", StringUtils.truncate("hello world", 5));
        assertEquals("hello...", StringUtils.truncate("hello world", 8));
    }
}
