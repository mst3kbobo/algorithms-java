package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void binarySearch() {

        int[] arrayOne = {3, 6, 8, 10, 12, 33, 39, 40, 67};
        int[] arrayTwo = {6, 21, 22, 39, 40, 52, 67, 87, 99, 101, 132, 186, 227};

        assertEquals(2, BinarySearch.binarySearch(arrayOne, 8));
        assertEquals(-1, BinarySearch.binarySearch(arrayTwo, 100));

    }
}