package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void bubbleSort() {

        int[] unsortedOne = {8, 5, 2, 9, 5, 6, 3};
        int[] sortedOne =   {2, 3, 5, 5, 6, 8, 9};
        assertArrayEquals(sortedOne, BubbleSort.bubbleSort(unsortedOne));

        int[] unsortedTwo = {16, 0, -1, 8, 22, 5, 10, 66, 3, 9};
        int[] sortedTwo =   {-1, 0, 3, 5, 8, 9, 10, 16, 22, 66};
        assertArrayEquals(sortedTwo, BubbleSort.bubbleSort(unsortedTwo));
    }
}