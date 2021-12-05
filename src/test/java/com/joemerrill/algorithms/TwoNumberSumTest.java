package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoNumberSumTest {

    @Test
    void TwoNumberSumTest() {
        TwoNumberSum tns = new TwoNumberSum();
        assertArrayEquals(new int[] {11, -1}, tns.twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10));
        assertArrayEquals(new int[2], tns.twoNumberSum(new int[]{0, 10, 11, -5, 6}, 12));
        assertArrayEquals(new int[] {5, 4}, tns.twoNumberSum(new int[]{5, 4, -1, 8, 6, 11}, 9));
    }
}