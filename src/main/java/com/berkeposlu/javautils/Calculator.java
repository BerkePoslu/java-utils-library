package com.berkeposlu.javautils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Utility class for mathematical calculations and operations.
 * 
 * @author Berke Poslu
 * @version 1.0.0
 */
public final class Calculator {

    private Calculator() {
        // Utility class - prevent instantiation
    }

    /**
     * Adds two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the sum
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the difference
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the product
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides two numbers.
     *
     * @param a the dividend
     * @param b the divisor
     * @return the quotient
     * @throws ArithmeticException if the divisor is zero
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    /**
     * Calculates the power of a number.
     *
     * @param base the base number
     * @param exponent the exponent
     * @return the result of base raised to the power of exponent
     */
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Calculates the square root of a number.
     *
     * @param number the number
     * @return the square root
     * @throws IllegalArgumentException if the number is negative
     */
    public static double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }

    /**
     * Calculates the factorial of a non-negative integer.
     *
     * @param n the number
     * @return the factorial
     * @throws IllegalArgumentException if n is negative
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Calculates the percentage of a value.
     *
     * @param value the value
     * @param total the total
     * @return the percentage
     */
    public static double percentage(double value, double total) {
        if (total == 0) {
            return 0;
        }
        return (value / total) * 100;
    }

    /**
     * Calculates a percentage of a value.
     *
     * @param value the value
     * @param percentage the percentage
     * @return the calculated amount
     */
    public static double percentageOf(double value, double percentage) {
        return (value * percentage) / 100;
    }

    /**
     * Rounds a number to a specified number of decimal places.
     *
     * @param value the value to round
     * @param decimalPlaces the number of decimal places
     * @return the rounded value
     */
    public static double round(double value, int decimalPlaces) {
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Decimal places cannot be negative");
        }
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(decimalPlaces, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Finds the minimum value in an array.
     *
     * @param values the array of values
     * @return the minimum value
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static double min(double... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        double min = values[0];
        for (double value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /**
     * Finds the maximum value in an array.
     *
     * @param values the array of values
     * @return the maximum value
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static double max(double... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        double max = values[0];
        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Calculates the average of an array of values.
     *
     * @param values the array of values
     * @return the average
     * @throws IllegalArgumentException if the array is null or empty
     */
    public static double average(double... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    /**
     * Calculates the sum of an array of values.
     *
     * @param values the array of values
     * @return the sum
     */
    public static double sum(double... values) {
        if (values == null || values.length == 0) {
            return 0;
        }
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }

    /**
     * Checks if a number is even.
     *
     * @param number the number to check
     * @return true if the number is even, false otherwise
     */
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Checks if a number is odd.
     *
     * @param number the number to check
     * @return true if the number is odd, false otherwise
     */
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    /**
     * Checks if a number is prime.
     *
     * @param number the number to check
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calculates the absolute value of a number.
     *
     * @param number the number
     * @return the absolute value
     */
    public static double abs(double number) {
        return Math.abs(number);
    }

    /**
     * Calculates the greatest common divisor (GCD) of two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the GCD
     */
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Calculates the least common multiple (LCM) of two numbers.
     *
     * @param a the first number
     * @param b the second number
     * @return the LCM
     */
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }
}
