package com.joemerrill.datastructures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    private final String TAG = "NodeTest";
    private final String TEST_DATA  = "Lorem ipsum";
    private Node testNodeA;
    private Node testNodeB;

    @BeforeEach
    void setUp() {
        System.out.println("Running Set Up: " + TAG);
        testNodeA = new Node(TEST_DATA);
        testNodeB = new Node("");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running Tear Down: " + TAG);

        testNodeA = null;
        testNodeB = null;
        assertNull(testNodeA);
        assertNull(testNodeB);
    }

    @Test
    void getDataTest() {
        System.out.println("Running: getDataTest");

        assertEquals(TEST_DATA, testNodeA.getData());
        assertEquals("", testNodeB.getData());
    }

    @Test
    void getNextTest() {
        System.out.println("Running: getNextTest");

        assertNull(testNodeA.getNext());

        testNodeA.setNext(testNodeB);
        assertNotNull(testNodeA.getNext());

        assertNull(testNodeB.getNext());
    }

    @Test
    void hasNextTest() {
        System.out.println("Running: hasNextTest");

        assertEquals(false, testNodeA.hasNext());
    }


}