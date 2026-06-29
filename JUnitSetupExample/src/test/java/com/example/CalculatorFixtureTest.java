package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Demonstrates the Arrange-Act-Assert (AAA) pattern,
 * Test Fixtures, and Setup (@Before) / Teardown (@After) methods in JUnit.
 */
public class CalculatorFixtureTest {

    private Calculator calculator;

    // Setup method executed before each test method
    @Before
    public void setUp() {
        System.out.println("[Setup] Initializing Calculator instance.");
        // Arrange (Fixture part)
        calculator = new Calculator();
    }

    // Teardown method executed after each test method
    @After
    public void tearDown() {
        System.out.println("[Teardown] Cleaning up Calculator instance.");
        calculator = null;
    }

    @Test
    public void testAddOperationUsingAAA() {
        // 1. Arrange
        int a = 15;
        int b = 25;
        int expectedResult = 40;

        // 2. Act
        int actualResult = calculator.add(a, b);

        // 3. Assert
        assertEquals("Addition result should match the sum of inputs", expectedResult, actualResult);
    }

    @Test
    public void testSubtractOperationUsingAAA() {
        // 1. Arrange
        int a = 50;
        int b = 20;
        int expectedResult = 30;

        // 2. Act
        int actualResult = calculator.subtract(a, b);

        // 3. Assert
        assertEquals("Subtraction result should match the difference of inputs", expectedResult, actualResult);
    }
}
