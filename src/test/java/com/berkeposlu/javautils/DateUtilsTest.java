package com.berkeposlu.javautils;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for DateUtils class.
 */
class DateUtilsTest {

    @Test
    void testFormatDate() {
        LocalDate date = LocalDate.of(2023, 12, 25);
        assertEquals("2023-12-25", DateUtils.formatDate(date, "yyyy-MM-dd"));
        assertEquals("25/12/2023", DateUtils.formatDate(date, "dd/MM/yyyy"));
        assertEquals("Dec 25, 2023", DateUtils.formatDate(date, "MMM dd, yyyy"));
        assertNull(DateUtils.formatDate(null, "yyyy-MM-dd"));
        assertNull(DateUtils.formatDate(date, null));
    }

    @Test
    void testFormatDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 12, 25, 14, 30, 45);
        assertEquals("2023-12-25 14:30:45", DateUtils.formatDateTime(dateTime, "yyyy-MM-dd HH:mm:ss"));
        assertEquals("25/12/2023 14:30", DateUtils.formatDateTime(dateTime, "dd/MM/yyyy HH:mm"));
        assertNull(DateUtils.formatDateTime(null, "yyyy-MM-dd HH:mm:ss"));
        assertNull(DateUtils.formatDateTime(dateTime, null));
    }

    @Test
    void testParseDate() {
        LocalDate expected = LocalDate.of(2023, 12, 25);
        assertEquals(expected, DateUtils.parseDate("2023-12-25", "yyyy-MM-dd"));
        assertEquals(expected, DateUtils.parseDate("25/12/2023", "dd/MM/yyyy"));
        assertNull(DateUtils.parseDate(null, "yyyy-MM-dd"));
        assertNull(DateUtils.parseDate("", "yyyy-MM-dd"));
        assertNull(DateUtils.parseDate("2023-12-25", null));
    }

    @Test
    void testParseDateTime() {
        LocalDateTime expected = LocalDateTime.of(2023, 12, 25, 14, 30, 45);
        assertEquals(expected, DateUtils.parseDateTime("2023-12-25 14:30:45", "yyyy-MM-dd HH:mm:ss"));
        assertNull(DateUtils.parseDateTime(null, "yyyy-MM-dd HH:mm:ss"));
        assertNull(DateUtils.parseDateTime("", "yyyy-MM-dd HH:mm:ss"));
        assertNull(DateUtils.parseDateTime("2023-12-25 14:30:45", null));
    }

    @Test
    void testDaysBetween() {
        LocalDate start = LocalDate.of(2023, 1, 1);
        LocalDate end = LocalDate.of(2023, 1, 10);
        assertEquals(9, DateUtils.daysBetween(start, end));
        assertEquals(-9, DateUtils.daysBetween(end, start));
        assertEquals(0, DateUtils.daysBetween(start, start));
        assertEquals(0, DateUtils.daysBetween(null, end));
        assertEquals(0, DateUtils.daysBetween(start, null));
    }

    @Test
    void testHoursBetween() {
        LocalDateTime start = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2023, 1, 1, 15, 0);
        assertEquals(5, DateUtils.hoursBetween(start, end));
        assertEquals(-5, DateUtils.hoursBetween(end, start));
        assertEquals(0, DateUtils.hoursBetween(start, start));
        assertEquals(0, DateUtils.hoursBetween(null, end));
        assertEquals(0, DateUtils.hoursBetween(start, null));
    }

    @Test
    void testIsInPast() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate today = LocalDate.now();
        
        assertTrue(DateUtils.isInPast(yesterday));
        assertFalse(DateUtils.isInPast(tomorrow));
        assertFalse(DateUtils.isInPast(today));
        assertFalse(DateUtils.isInPast(null));
    }

    @Test
    void testIsInFuture() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate today = LocalDate.now();
        
        assertFalse(DateUtils.isInFuture(yesterday));
        assertTrue(DateUtils.isInFuture(tomorrow));
        assertFalse(DateUtils.isInFuture(today));
        assertFalse(DateUtils.isInFuture(null));
    }

    @Test
    void testIsToday() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate today = LocalDate.now();
        
        assertFalse(DateUtils.isToday(yesterday));
        assertFalse(DateUtils.isToday(tomorrow));
        assertTrue(DateUtils.isToday(today));
        assertFalse(DateUtils.isToday(null));
    }

    @Test
    void testGetCurrentDateISO() {
        String currentDate = DateUtils.getCurrentDateISO();
        assertNotNull(currentDate);
        assertTrue(currentDate.matches("\\d{4}-\\d{2}-\\d{2}"));
    }

    @Test
    void testGetCurrentDateTimeISO() {
        String currentDateTime = DateUtils.getCurrentDateTimeISO();
        assertNotNull(currentDateTime);
        assertTrue(currentDateTime.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}"));
    }

    @Test
    void testAddDays() {
        LocalDate date = LocalDate.of(2023, 1, 1);
        LocalDate expected = LocalDate.of(2023, 1, 11);
        assertEquals(expected, DateUtils.addDays(date, 10));
        assertEquals(date, DateUtils.addDays(date, 0));
        assertNull(DateUtils.addDays(null, 10));
    }

    @Test
    void testSubtractDays() {
        LocalDate date = LocalDate.of(2023, 1, 11);
        LocalDate expected = LocalDate.of(2023, 1, 1);
        assertEquals(expected, DateUtils.subtractDays(date, 10));
        assertEquals(date, DateUtils.subtractDays(date, 0));
        assertNull(DateUtils.subtractDays(null, 10));
    }
}
