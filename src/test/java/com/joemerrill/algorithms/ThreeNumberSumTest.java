package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeNumberSumTest {

    @Test
    void threeNumberSum() {

        assertArrayEquals(new int[][] {{-8, 2, 6}, {-8, 3, 5}, {-6, 1, 5}},
                ThreeNumberSum.threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0));

        assertArrayEquals(new int[0][0],
                ThreeNumberSum.threeNumberSum(new int[] {10, 3, -8, 4}, 2));

        assertArrayEquals(new int[][] {{-8, 3, 10}},
                ThreeNumberSum.threeNumberSum(new int[] {10, 3, -8, 4}, 5));
    }
}