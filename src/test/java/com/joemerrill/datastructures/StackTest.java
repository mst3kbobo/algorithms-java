package com.joemerrill.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private final String TAG = "StackTest";
    Stack testStack;

    @BeforeEach
    void setUp() {
        System.out.println("Running Set Up: " + TAG);

        testStack = new Stack(3);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running Tear Down: " + TAG);

        testStack = null;
        assertNull(testStack);
    }

    @Test
    void pushTest() {
        System.out.println("Running: pushTest");

        testStack.push("A");
    }

    @Test
    void pushTest_whenErrorThrown_thenAssertionSucceeds() {
        System.out.println("Running: pushTest_whenErrorThrown_thenAssertionSucceeds");

        testStack.push("A");
        testStack.push("B");
        testStack.push("C");

        Error error = assertThrows(Error.class, () -> {
            testStack.push("D");
        });

        String actualMessage = error.getMessage();
        assertTrue(actualMessage.contains(Stack.OVERFLOW_ERROR_MESSAGE), "Expected Overflow, but no error was thrown.");
    }

    @Test
    void popTest() {
        System.out.println("Running: popTest");

        testStack.push("A");
        testStack.push("B");
        assertEquals("B", testStack.pop());
        assertEquals("A", testStack.pop());
    }

    @Test
    void popTest_whenErrorThrown_thenAssertionSucceeds() {
        System.out.println("Running: popTest_whenErrorThrown_thenAssertionSucceeds");

        testStack.push("A");

        Error error = assertThrows(Error.class, () -> {
            testStack.pop();
            testStack.pop();
        });

        String actualMessage = error.getMessage();
        assertTrue(actualMessage.contains(Stack.UNDERFLOW_ERROR_MESSAGE), "Expected Underflow, but no error was thrown.");
    }

    @Test
    void peekTest() {
        System.out.println("Running: peekTest");

        testStack.push("A");
        assertEquals("A", testStack.peek());
    }

    @Test
    void hasSpaceTest() {
        System.out.println("Running: hasSpaceTest");

        testStack.push("A");
        assertEquals(true, testStack.hasSpace());
        testStack.push("B");
        testStack.push("C");
        assertEquals(false, testStack.hasSpace());
    }

    @Test
    void isEmptyTest() {
        System.out.println("Running: isEmptyTest");

        assertEquals(true, testStack.isEmpty());
        testStack.push("A");
        assertEquals(false, testStack.isEmpty());
    }

    @Test
    void sizeTest() {
        System.out.println("Running: sizeTest");

        assertEquals(0, testStack.getSize());
        testStack.push("A");
        assertEquals(1, testStack.getSize());
    }
}