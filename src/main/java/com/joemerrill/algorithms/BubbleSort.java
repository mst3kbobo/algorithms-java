package com.joemerrill.algorithms;

import java.util.Arrays;

/**
 * This program demonstrates a Bubble Sort algorithm.
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {8, 5, 2, 9, 5, 6, 3};

        System.out.println("Before: " + Arrays.toString(array));
        System.out.println(" After: " + Arrays.toString(bubbleSort(array)));
    }

    /**
     * Bubble Sort Algorithm. The method takes an unsorted array of integers and returns it sorted smallest to greatest.
     * Complexity Analysis:
     * - Time: O(n^2) for the while unsorted loop and nested for loops
     * - Space: O(1)
     * @param array unsorted array of integers
     * @return sorted array
     */
    public static int[] bubbleSort(int[] array) {

        boolean isSorted = false;
        int counter = 0; // Counter will be used for slight optimization on subsequent iterations.

        while (!isSorted) {

            isSorted = true; // Assumption that will break out of the loop if there are no swaps.

            // Loop from the beginning of the array until its (size - 1) because
            // we don't want to compare the last element to an out of bounds element.
            // Subtract the counter for small iteration optimization.
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false; // Set to false because array was not sorted.
                }
            }

            // Increment counter because the last element (of the for loop) is in its final position.
            // No need to compare it against another number anymore and there is a minor optimization
            // to be had here.
            counter += 1;
        }

        return array;
    }

    private static void swap(int a, int b, int[] array) {
        int tempA = array[a];
        array[a] = array[b];
        array[b] = tempA;

    }

}

// Test
//  0, 1, 2, 3, 4, 5, 6 Indices
// [8, 5, 2, 9, 5, 6, 3] initial array
//
// 1st Iteration: [8, 5, 2, 9, 5, 6, 3] for loop from 0 until 6 (array.length - 1 - counter)
// 8 > 5 swap     [5, 8, 2, 9, 5, 6, 3]
// 8 > 2 swap     [5, 2, 8, 9, 5, 6, 3]
// 8 < 9 pass
// 9 > 5 swap     [5, 2, 8, 5, 9, 6, 3]
// 9 > 6 swap     [5, 2, 8, 5, 6, 9, 3]
// 9 > 3 swap     [5, 2, 8, 5, 6, 3, 9]
// isSorted == false and counter == 1
//
// 2nd Iteration: [5, 2, 8, 5, 6, 3, 9] for loop from 0 until 5 (array.length - 1 - counter)
// 5 > 2 swap     [2, 5, 8, 5, 6, 3, 9]
// 5 < 8 pass
// 8 > 5 swap     [2, 5, 5, 8, 6, 3, 9]
// 8 > 6 swap     [2, 5, 5, 6, 8, 3, 9]
// 8 > 3 swap     [2, 5, 5, 6, 3, 8, 9]
// isSorted == false and counter == 2
//
// 3rd Iteration: [2, 5, 5, 6, 3, 8, 9] for loop from 0 until 4 (array.length - 1 - counter)
// 2 < 5 pass
// 5 == 5 pass
// 5 < 6 pass
// 5 > 3 swap     [2, 5, 5, 3, 6, 8, 9]
// isSorted == false and counter == 3
//
// 4th Iteration: [2, 5, 5, 3, 6, 8, 9] for loop from 0 until 3 (array.length - 1 - counter)
// 2 < 5 pass
// 5 == 5 pass
// 5 > 3 swap     [2, 5, 3, 5, 6, 8, 9]
// isSorted == false and counter == 4
//
// 5th Iteration: [2, 5, 3, 5, 6, 8, 9] for loop from 0 until 2 (array.length - 1 - counter)
// 2 < 5 pass
// 5 > 3 swap     [2, 3, 5, 5, 6, 8, 9]
// isSorted == false and counter == 5
//
// 6th Iteration: [2, 3, 5, 5, 6, 8, 9] for loop from 0 until 1 (array.length - 1 - counter)
// 2 < 3 pass
// isSorted == true and counter == 5
// no swaps took place on 6th iteration
//
