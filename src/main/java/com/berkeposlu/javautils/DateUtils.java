package com.berkeposlu.javautils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Utility class for common date and time operations.
 * 
 * @author Berke Poslu
 * @version 1.0.0
 */
public final class DateUtils {

    private DateUtils() {
        // Utility class - prevent instantiation
    }

    /**
     * Formats a LocalDate using the given pattern.
     *
     * @param date the date to format
     * @param pattern the pattern to use (e.g., "yyyy-MM-dd")
     * @return the formatted date string
     */
    public static String formatDate(LocalDate date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Formats a LocalDateTime using the given pattern.
     *
     * @param dateTime the datetime to format
     * @param pattern the pattern to use (e.g., "yyyy-MM-dd HH:mm:ss")
     * @return the formatted datetime string
     */
    public static String formatDateTime(LocalDateTime dateTime, String pattern) {
        if (dateTime == null || pattern == null) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Parses a date string using the given pattern.
     *
     * @param dateStr the date string to parse
     * @param pattern the pattern to use
     * @return the parsed LocalDate
     */
    public static LocalDate parseDate(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Parses a datetime string using the given pattern.
     *
     * @param dateTimeStr the datetime string to parse
     * @param pattern the pattern to use
     * @return the parsed LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTimeStr, String pattern) {
        if (StringUtils.isEmpty(dateTimeStr) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * Calculates the number of days between two dates.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return the number of days between the dates
     */
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Calculates the number of hours between two datetimes.
     *
     * @param startDateTime the start datetime
     * @param endDateTime the end datetime
     * @return the number of hours between the datetimes
     */
    public static long hoursBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime == null || endDateTime == null) {
            return 0;
        }
        return ChronoUnit.HOURS.between(startDateTime, endDateTime);
    }

    /**
     * Checks if a date is in the past.
     *
     * @param date the date to check
     * @return true if the date is in the past, false otherwise
     */
    public static boolean isInPast(LocalDate date) {
        if (date == null) {
            return false;
        }
        return date.isBefore(LocalDate.now());
    }

    /**
     * Checks if a date is in the future.
     *
     * @param date the date to check
     * @return true if the date is in the future, false otherwise
     */
    public static boolean isInFuture(LocalDate date) {
        if (date == null) {
            return false;
        }
        return date.isAfter(LocalDate.now());
    }

    /**
     * Checks if a date is today.
     *
     * @param date the date to check
     * @return true if the date is today, false otherwise
     */
    public static boolean isToday(LocalDate date) {
        if (date == null) {
            return false;
        }
        return date.equals(LocalDate.now());
    }

    /**
     * Gets the current date in ISO format (yyyy-MM-dd).
     *
     * @return the current date as a string
     */
    public static String getCurrentDateISO() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * Gets the current datetime in ISO format (yyyy-MM-ddTHH:mm:ss).
     *
     * @return the current datetime as a string
     */
    public static String getCurrentDateTimeISO() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    /**
     * Adds days to a date.
     *
     * @param date the base date
     * @param days the number of days to add
     * @return the new date
     */
    public static LocalDate addDays(LocalDate date, long days) {
        if (date == null) {
            return null;
        }
        return date.plusDays(days);
    }

    /**
     * Subtracts days from a date.
     *
     * @param date the base date
     * @param days the number of days to subtract
     * @return the new date
     */
    public static LocalDate subtractDays(LocalDate date, long days) {
        if (date == null) {
            return null;
        }
        return date.minusDays(days);
    }
}
