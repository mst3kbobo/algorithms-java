package com.joemerrill.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private final String TAG = "QueueTest";
    Queue testQueueBounded3;
    Queue testQueueUnbounded;

    @BeforeEach
    void setUp() {
        System.out.println("Running Set Up: " + TAG);

        testQueueBounded3 = new Queue(3);
        testQueueUnbounded = new Queue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running Tear Down: " + TAG);

        testQueueBounded3 = null;
        testQueueUnbounded = null;
        assertNull(testQueueBounded3);
        assertNull(testQueueUnbounded);
    }

    @Test
    void enqueueTest() {
        System.out.println("Running: enqueueTest");

        testQueueBounded3.enqueue("A");
    }

    @Test
    void enqueueTest_whenErrorThrown_thenAssertionSucceeds() {
        System.out.println("Running: enqueueTest_whenErrorThrown_thenAssertionSucceeds");

        testQueueBounded3.enqueue("A");
        testQueueBounded3.enqueue("B");
        testQueueBounded3.enqueue("C");

        Error error = assertThrows(Error.class, () -> {
            testQueueBounded3.enqueue("D");
        });

        String actualMessage = error.getMessage();
        assertTrue(actualMessage.contains(Queue.OVERFLOW_ERROR_MESSAGE), "Expected Overflow, but no error was thrown.");
    }

    @Test
    void dequeueTest() {
        System.out.println("Running: dequeueTest");

        testQueueBounded3.enqueue("A");
        testQueueBounded3.enqueue("B");
        assertEquals("A", testQueueBounded3.dequeue());
        assertEquals("B", testQueueBounded3.dequeue());
    }

    @Test
    void dequeueTest_whenErrorThrown_thenAssertionSucceeds() {
        System.out.println("Running: dequeueTest_whenErrorThrown_thenAssertionSucceeds");

        testQueueBounded3.enqueue("A");

        Error error = assertThrows(Error.class, () -> {
            testQueueBounded3.dequeue();
            testQueueBounded3.dequeue();
        });

        String actualMessage = error.getMessage();
        assertTrue(actualMessage.contains(Queue.UNDERFLOW_ERROR_MESSAGE), "Expected Underflow, but no error was thrown.");
    }

    @Test
    void peekTest() {
        System.out.println("Running: peekTest");

        testQueueBounded3.enqueue("A");
        assertEquals("A", testQueueBounded3.peek());
        assertEquals(1, testQueueBounded3.getSize());
    }

    @Test
    void hasSpaceTest() {
        System.out.println("Running: hasSpaceTest");

        testQueueBounded3.enqueue("A");
        assertEquals(true, testQueueBounded3.hasSpace());
        testQueueBounded3.enqueue("B");
        testQueueBounded3.enqueue("C");
        assertEquals(false, testQueueBounded3.hasSpace());
    }

    @Test
    void isEmptyTest() {
        System.out.println("Running: isEmptyTest");

        assertEquals(true, testQueueUnbounded.isEmpty());
        testQueueUnbounded.enqueue("A");
        assertEquals(false, testQueueUnbounded.isEmpty());
    }

    @Test
    void sizeTest() {
        System.out.println("Running: sizeTest");

        assertEquals(0, testQueueBounded3.getSize());
        assertEquals(0, testQueueUnbounded.getSize());
    }

}