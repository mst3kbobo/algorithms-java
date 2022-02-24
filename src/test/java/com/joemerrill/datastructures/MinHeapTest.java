package com.joemerrill.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    private final String TAG = "MinHeapTest";

    private MinHeap heap;

    @BeforeEach
    void setUp() {
        System.out.println("Running Set Up: " + TAG);

        heap = new MinHeap();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running Tear Down: " + TAG);
    }

    @Test
    void getHeap() {

        assertEquals(new ArrayList<Integer>(), heap.getHeap());
    }

    @Test
    void getSize() {

        assertEquals(0, heap.getSize());
    }

    @Test
    void add() {

        heap.add(39);
        assertEquals(1, heap.getSize());
    }

    @Test
    void popMin() {

        heap.add(10);
        assertEquals(10, heap.popMin());
        heap.add(25);
        heap.add(10);
        assertEquals(10, heap.popMin());
        assertEquals(25, heap.popMin());

        heap.add(5);
        heap.add(10);
        heap.add(18);
        heap.add(6);
        heap.add(2);
        heap.add(20);
        heap.add(7);
        assertEquals(2, heap.popMin());
        assertEquals(5, heap.popMin());
        assertEquals(6, heap.popMin());
        assertEquals(7, heap.popMin());
        assertEquals(10, heap.popMin());
        assertEquals(18, heap.popMin());
        assertEquals(20, heap.popMin());
    }

    @Test
    void popMin_whenErrorThrown_thenAssertionSucceeds() {
        heap.add(10);
        assertEquals(10, heap.popMin());

        Error error = assertThrows(Error.class, () -> {
            heap.popMin();
        });

        String actualMessage = error.getMessage();
        assertTrue(actualMessage.contains(MinHeap.MINHEAP_EMPTY_ERROR_MESSAGE), "Expected error, but no error was thrown.");
    }

    @Test
    void getParentIndex() {
        // Root
        assertEquals(0, heap.getParentIndex(0));
        // Direct children of root
        assertEquals(0, heap.getParentIndex(1));
        assertEquals(0, heap.getParentIndex(2));
        // Others
        assertEquals(1, heap.getParentIndex(3));
        assertEquals(1, heap.getParentIndex(4));
        assertEquals(2, heap.getParentIndex(5));
        assertEquals(2, heap.getParentIndex(6));
        assertEquals(3, heap.getParentIndex(7));
        assertEquals(3, heap.getParentIndex(8));
        assertEquals(4, heap.getParentIndex(9));
    }

    @Test
    void getLeftChildIndex() {
        assertEquals(1, heap.getLeftChildIndex(0));
        assertEquals(3, heap.getLeftChildIndex(1));
        assertEquals(5, heap.getLeftChildIndex(2));
        assertEquals(7, heap.getLeftChildIndex(3));
        assertEquals(9, heap.getLeftChildIndex(4));
    }

    @Test
    void getRightChildIndex() {
        assertEquals(2, heap.getRightChildIndex(0));
        assertEquals(4, heap.getRightChildIndex(1));
        assertEquals(6, heap.getRightChildIndex(2));
        assertEquals(8, heap.getRightChildIndex(3));
        assertEquals(10, heap.getRightChildIndex(4));
    }


}