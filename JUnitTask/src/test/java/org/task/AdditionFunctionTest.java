package org.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for testing the addition function.
 * This class demonstrates comprehensive testing with various scenarios
 * including edge cases, boundary conditions, and typical use cases.
 */
@DisplayName("Addition Function Tests")
public class AdditionFunctionTest {
    private Calculator calculator;

    /**
     * Setup method that runs before each test method.
     * Initializes the Calculator instance to ensure clean state for each test.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up test environment...");
    }

    /**
     * Cleanup method that runs after each test method.
     * Can be used for cleanup operations if needed.
     */
    @AfterEach
    void tearDown() {
        System.out.println("Test completed, cleaning up...");
        calculator = null;
    }

    /**
     * Test addition of two positive integers.
     * Uses assertEquals to verify the exact result of adding positive numbers.
     */
    @Test
    @DisplayName("Test addition of positive numbers")
    void testAddPositiveNumbers() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 8;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result,
                "Addition of 5 and 3 should equal 8");
    }

    /**
     * Test addition of two negative integers.
     * Verifies that negative number addition works correctly.
     */
    @Test
    @DisplayName("Test addition of negative numbers")
    void testAddNegativeNumbers() {
        // Arrange
        int a = -7;
        int b = -3;
        int expected = -10;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(expected, result,
                "Addition of -7 and -3 should equal -10");
    }

    /**
     * Test addition with zero values.
     * Tests the additive identity property (adding zero should not change the value).
     */
    @Test
    @DisplayName("Test addition with zero")
    void testAddWithZero() {
        // Test adding zero to a positive number
        assertEquals(5, calculator.add(5, 0),
                "Adding 0 to 5 should equal 5");

        // Test adding zero to a negative number
        assertEquals(-3, calculator.add(-3, 0),
                "Adding 0 to -3 should equal -3");

        // Test adding two zeros
        assertEquals(0, calculator.add(0, 0),
                "Adding 0 to 0 should equal 0");
    }

    /**
     * Test addition of positive and negative numbers.
     * Verifies subtraction-like behavior when adding positive and negative values.
     */
    @Test
    @DisplayName("Test addition of positive and negative numbers")
    void testAddPositiveAndNegative() {
        // Test where positive number is larger
        assertEquals(2, calculator.add(5, -3),
                "Adding 5 and -3 should equal 2");

        // Test where negative number has larger absolute value
        assertEquals(-2, calculator.add(3, -5),
                "Adding 3 and -5 should equal -2");

        // Test where they cancel out
        assertEquals(0, calculator.add(4, -4),
                "Adding 4 and -4 should equal 0");
    }

    /**
     * Test addition with large numbers (boundary testing).
     * Uses assertTrue to verify the result is within expected range.
     */
    @Test
    @DisplayName("Test addition with large numbers")
    void testAddLargeNumbers() {
        // Test with large positive numbers
        int a = 1000000;
        int b = 2000000;
        int result = calculator.add(a, b);

        assertTrue(result > 0,
                "Result of adding large positive numbers should be positive");
        assertEquals(3000000, result,
                "Addition of 1000000 and 2000000 should equal 3000000");
    }

    /**
     * Test addition near integer overflow boundary.
     * Demonstrates testing edge cases near Integer.MAX_VALUE.
     */
    @Test
    @DisplayName("Test addition near integer limits")
    void testAddNearIntegerLimits() {
        // Test addition that stays within integer range
        int nearMax = Integer.MAX_VALUE - 100;
        int small = 50;
        int result = calculator.add(nearMax, small);

        assertTrue(result < Integer.MAX_VALUE,
                "Result should be less than Integer.MAX_VALUE");
        assertEquals(Integer.MAX_VALUE - 50, result,
                "Addition should produce correct result within integer range");
    }

    /**
     * Test commutative property of addition.
     * Verifies that a + b = b + a (order doesn't matter).
     */
    @Test
    @DisplayName("Test commutative property of addition")
    void testCommutativeProperty() {
        int a = 15;
        int b = 25;

        int result1 = calculator.add(a, b);
        int result2 = calculator.add(b, a);

        assertEquals(result1, result2,
                "Addition should be commutative: a + b should equal b + a");
    }

    /**
     * Test multiple assertions in one test method.
     * Uses assertAll to group multiple assertions and execute all of them.
     */
    @Test
    @DisplayName("Test multiple scenarios with assertAll")
    void testMultipleScenarios() {
        assertAll("Multiple addition scenarios",
                () -> assertEquals(10, calculator.add(7, 3),
                        "7 + 3 should equal 10"),
                () -> assertEquals(-5, calculator.add(-2, -3),
                        "-2 + (-3) should equal -5"),
                () -> assertEquals(1, calculator.add(-4, 5),
                        "-4 + 5 should equal 1"),
                () -> assertTrue(calculator.add(10, 5) > 0,
                        "10 + 5 should be positive"),
                () -> assertNotEquals(0, calculator.add(1, 1),
                        "1 + 1 should not equal 0")
        );
    }

    /**
     * Test that verifies the function returns expected type.
     * Uses assertNotNull to ensure the function doesn't return null.
     */
    @Test
    @DisplayName("Test return value is not null")
    void testReturnValueNotNull() {
        Integer result = calculator.add(1, 2);

        assertNotNull(result,
                "Addition function should never return null");
        assertInstanceOf(Integer.class, result, "Result should be an Integer type");
    }
}