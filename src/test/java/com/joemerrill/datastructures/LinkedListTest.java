package com.joemerrill.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private final String TAG = "LinkedListTest";
    LinkedList testListA;
    LinkedList testListB;

    @BeforeEach
    void setUp() {
        System.out.println("Running Set Up: " + TAG);

        testListA = new LinkedList();
        for (int i = 0; i <= 20; i++) {
            testListA.addToTail(Integer.toString(i));
        }

        testListB = new LinkedList();
        for (int i = 0; i <= 4; i++) {
            testListB.addToTail(Integer.toString(i));
        }
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running Tear Down: " + TAG);

        testListA = null;
        testListB = null;
        assertNull(testListA);
        assertNull(testListB);
    }

    @Test
    void nthLastNodeTest() {
        System.out.println("Running: nthLastNodeTest");

        assertEquals("16", testListA.nthLastNode(5).getData());
        assertEquals("3", testListB.nthLastNode(2).getData());
    }

    @Test
    void middleNodeTest() {
        System.out.println("Running: middleNodeTest");

        assertEquals("10", testListA.middleNode().getData());
        assertEquals("2", testListB.middleNode().getData());
    }
}