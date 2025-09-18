package com.berkeposlu.javautils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Calculator class.
 */
class CalculatorTest {

    private static final double DELTA = 0.0001;

    @Test
    void testAdd() {
        assertEquals(5.0, Calculator.add(2.0, 3.0), DELTA);
        assertEquals(0.0, Calculator.add(-1.0, 1.0), DELTA);
        assertEquals(-5.0, Calculator.add(-2.0, -3.0), DELTA);
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, Calculator.subtract(3.0, 2.0), DELTA);
        assertEquals(-2.0, Calculator.subtract(-1.0, 1.0), DELTA);
        assertEquals(1.0, Calculator.subtract(-2.0, -3.0), DELTA);
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, Calculator.multiply(2.0, 3.0), DELTA);
        assertEquals(-6.0, Calculator.multiply(-2.0, 3.0), DELTA);
        assertEquals(0.0, Calculator.multiply(0.0, 5.0), DELTA);
    }

    @Test
    void testDivide() {
        assertEquals(2.0, Calculator.divide(6.0, 3.0), DELTA);
        assertEquals(-2.0, Calculator.divide(-6.0, 3.0), DELTA);
        assertEquals(0.0, Calculator.divide(0.0, 5.0), DELTA);
        
        assertThrows(ArithmeticException.class, () -> Calculator.divide(5.0, 0.0));
    }

    @Test
    void testPower() {
        assertEquals(8.0, Calculator.power(2.0, 3.0), DELTA);
        assertEquals(1.0, Calculator.power(5.0, 0.0), DELTA);
        assertEquals(0.25, Calculator.power(2.0, -2.0), DELTA);
    }

    @Test
    void testSqrt() {
        assertEquals(3.0, Calculator.sqrt(9.0), DELTA);
        assertEquals(0.0, Calculator.sqrt(0.0), DELTA);
        assertEquals(1.414, Calculator.sqrt(2.0), 0.001);
        
        assertThrows(IllegalArgumentException.class, () -> Calculator.sqrt(-1.0));
    }

    @Test
    void testFactorial() {
        assertEquals(1, Calculator.factorial(0));
        assertEquals(1, Calculator.factorial(1));
        assertEquals(2, Calculator.factorial(2));
        assertEquals(6, Calculator.factorial(3));
        assertEquals(24, Calculator.factorial(4));
        assertEquals(120, Calculator.factorial(5));
        
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(-1));
    }

    @Test
    void testPercentage() {
        assertEquals(50.0, Calculator.percentage(50.0, 100.0), DELTA);
        assertEquals(25.0, Calculator.percentage(25.0, 100.0), DELTA);
        assertEquals(0.0, Calculator.percentage(0.0, 100.0), DELTA);
        assertEquals(0.0, Calculator.percentage(50.0, 0.0), DELTA);
    }

    @Test
    void testPercentageOf() {
        assertEquals(50.0, Calculator.percentageOf(100.0, 50.0), DELTA);
        assertEquals(25.0, Calculator.percentageOf(100.0, 25.0), DELTA);
        assertEquals(0.0, Calculator.percentageOf(100.0, 0.0), DELTA);
    }

    @Test
    void testRound() {
        assertEquals(3.14, Calculator.round(3.14159, 2), DELTA);
        assertEquals(3.0, Calculator.round(3.14159, 0), DELTA);
        assertEquals(3.1416, Calculator.round(3.14159, 4), DELTA);
        
        assertThrows(IllegalArgumentException.class, () -> Calculator.round(3.14, -1));
    }

    @Test
    void testMin() {
        assertEquals(1.0, Calculator.min(1.0, 2.0, 3.0), DELTA);
        assertEquals(-5.0, Calculator.min(1.0, -5.0, 3.0), DELTA);
        assertEquals(2.0, Calculator.min(2.0), DELTA);
        
        assertThrows(IllegalArgumentException.class, () -> Calculator.min());
        assertThrows(IllegalArgumentException.class, () -> Calculator.min((double[]) null));
    }

    @Test
    void testMax() {
        assertEquals(3.0, Calculator.max(1.0, 2.0, 3.0), DELTA);
        assertEquals(3.0, Calculator.max(1.0, -5.0, 3.0), DELTA);
        assertEquals(2.0, Calculator.max(2.0), DELTA);
        
        assertThrows(IllegalArgumentException.class, () -> Calculator.max());
        assertThrows(IllegalArgumentException.class, () -> Calculator.max((double[]) null));
    }

    @Test
    void testAverage() {
        assertEquals(2.0, Calculator.average(1.0, 2.0, 3.0), DELTA);
        assertEquals(0.0, Calculator.average(-1.0, 0.0, 1.0), DELTA);
        assertEquals(5.0, Calculator.average(5.0), DELTA);
        
        assertThrows(IllegalArgumentException.class, () -> Calculator.average());
        assertThrows(IllegalArgumentException.class, () -> Calculator.average((double[]) null));
    }

    @Test
    void testSum() {
        assertEquals(6.0, Calculator.sum(1.0, 2.0, 3.0), DELTA);
        assertEquals(0.0, Calculator.sum(-1.0, 0.0, 1.0), DELTA);
        assertEquals(5.0, Calculator.sum(5.0), DELTA);
        assertEquals(0.0, Calculator.sum(), DELTA);
        assertEquals(0.0, Calculator.sum((double[]) null), DELTA);
    }

    @Test
    void testIsEven() {
        assertTrue(Calculator.isEven(0));
        assertTrue(Calculator.isEven(2));
        assertTrue(Calculator.isEven(-4));
        
        assertFalse(Calculator.isEven(1));
        assertFalse(Calculator.isEven(-3));
    }

    @Test
    void testIsOdd() {
        assertTrue(Calculator.isOdd(1));
        assertTrue(Calculator.isOdd(-3));
        assertTrue(Calculator.isOdd(5));
        
        assertFalse(Calculator.isOdd(0));
        assertFalse(Calculator.isOdd(2));
        assertFalse(Calculator.isOdd(-4));
    }

    @Test
    void testIsPrime() {
        assertTrue(Calculator.isPrime(2));
        assertTrue(Calculator.isPrime(3));
        assertTrue(Calculator.isPrime(5));
        assertTrue(Calculator.isPrime(7));
        assertTrue(Calculator.isPrime(11));
        assertTrue(Calculator.isPrime(13));
        
        assertFalse(Calculator.isPrime(0));
        assertFalse(Calculator.isPrime(1));
        assertFalse(Calculator.isPrime(4));
        assertFalse(Calculator.isPrime(6));
        assertFalse(Calculator.isPrime(8));
        assertFalse(Calculator.isPrime(9));
        assertFalse(Calculator.isPrime(10));
    }

    @Test
    void testAbs() {
        assertEquals(5.0, Calculator.abs(5.0), DELTA);
        assertEquals(5.0, Calculator.abs(-5.0), DELTA);
        assertEquals(0.0, Calculator.abs(0.0), DELTA);
    }

    @Test
    void testGcd() {
        assertEquals(5, Calculator.gcd(10, 5));
        assertEquals(6, Calculator.gcd(12, 18));
        assertEquals(1, Calculator.gcd(7, 13));
        assertEquals(4, Calculator.gcd(-12, 8));
        assertEquals(5, Calculator.gcd(0, 5));
    }

    @Test
    void testLcm() {
        assertEquals(10, Calculator.lcm(10, 5));
        assertEquals(36, Calculator.lcm(12, 18));
        assertEquals(91, Calculator.lcm(7, 13));
        assertEquals(24, Calculator.lcm(-12, 8));
        assertEquals(0, Calculator.lcm(0, 5));
        assertEquals(0, Calculator.lcm(5, 0));
    }
}
