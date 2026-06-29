package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Demonstrates various assertions available in JUnit 4.
 */
public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals - validates expected matches actual
        assertEquals(5, 2 + 3);

        // Assert true - validates condition evaluates to true
        assertTrue(5 > 3);

        // Assert false - validates condition evaluates to false
        assertFalse(5 < 3);

        // Assert null - validates reference is null
        assertNull(null);

        // Assert not null - validates reference is instantiated
        assertNotNull(new Object());
        
        // Assert same - validates both refer to the exact same object in memory
        String str1 = "JUnit";
        String str2 = "JUnit";
        assertSame(str1, str2);

        // Assert array equals - validates both arrays have equal elements in the same order
        int[] expectedArray = {1, 2, 3};
        int[] actualArray = {1, 2, 3};
        assertArrayEquals(expectedArray, actualArray);
    }
}
