package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNLargestNumbersTest {

    @Test
    void findLargest() {

        int[] arrayA = {521, 8, -4, 4, 55, 34, -89, -147, 33, 10, 245, 25, 45, 16, -8, 55};
        assertArrayEquals(new int[] {55, 245, 521}, FindNLargestNumbers.findLargest(3, arrayA));

        int[] arrayB = {30, 16, 8, 99};
        assertArrayEquals(new int[0], FindNLargestNumbers.findLargest(5, arrayB));
        assertArrayEquals(new int[] {16, 30, 99}, FindNLargestNumbers.findLargest(3, arrayB));
    }
}