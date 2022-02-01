package com.joemerrill.algorithms;

import java.util.Arrays;

/**
 * This program demonstrates finding the N largest numbers in an unsorted array.
 */
public class FindNLargestNumbers {

    public static void main(String[] args) {

        int quantity = 3;
        int[] array = {521, 8, -4, 4, 55, 34, -89, -147, 33, 10, 245, 25, 45, 16, -8, 55};
        int[] expectedResult = {55, 245, 521};

        System.out.println("Expected Result: " + Arrays.toString(expectedResult));
        System.out.println("  Actual Result: " + Arrays.toString(findLargest(quantity, array)));

    }

    /**
     * Find N Largest Numbers in a provided array.
     * @param quantity The number (N) of integers to find in the provided array.
     * @param array An unsorted array of integers.
     * @return A sorted array of integers. Or empty array if quantity requested is greater than array length.
     */
    public static int[] findLargest(int quantity, int[] array) {

        // Edge case if quantity requested is larger than number of elements in array.
        if (quantity > array.length) {
            return new int[0];
        }

        // Declare, initialize, and populate final array with smallest integer value;
        int[] sortedLargest = new int[quantity];
        Arrays.fill(sortedLargest, Integer.MIN_VALUE);

        for (int number : array) {

            // Loop through sortedLargest from largest to smallest (right to left) and check against number.
            for (int i = sortedLargest.length - 1; i >= 0; i--) {

                if (number > sortedLargest[i]) {

                    // Number is greater than element at position i. Shift existing elements down.
                    for (int j = 0; j < i; j++) {
                        sortedLargest[j] = sortedLargest[j + 1];
                    }

                    // Finally, set the new largest number in its current index and break out of the sortedLargest loop.
                    sortedLargest[i] = number;
                    break;
                }
            }
        }

        return sortedLargest;
    }
}

// Test
//    0, 1,  2, 3,  4,  5,   6,    7,  8,  9,  10, 11, 12, 13, 14, 15  Indices
// [521, 8, -4, 4, 55, 34, -89, -147, 33, 10, 245, 25, 45, 16, -8, 55] input array
// quantity = 3
//
// Iterations:
// -----------
// Outside for each: number = 521
//   Inside for: i = 2; 521 > -2147483648
//     Inside for: [-2147483648, -2147483648, 521]
//
// Outside for each: number = 8
//   Inside for: i = 2; 8 < 521
//   Inside for: i = 1; 8 > -2147483648
//     Inside for: [-2147483648, 8, 521]
//
// Outside for each: number = -4
//   Inside for: i = 2; -4 < 521
//   Inside for: i = 1; -4 < 8
//   Inside for: i = 0; -4 > -2147483648
//     Inside for: [-4, 8, 521]
//
// Outside for each: number = 4
//   Inside for: i = 2; 4 < 521
//   Inside for: i = 1; 4 < 8
//   Inside for: i = 0; 4 > -4
//     Inside for: [4, 8, 521]
//
// Outside for each: number = 55
//   Inside for: i = 2; 55 < 521
//   Inside for: i = 1; 55 > 8
//     Inside for: [8, 55, 521]
//
// Outside for each: number = 34
//   Inside for: i = 2; 34 < 521
//   Inside for: i = 1; 34 < 55
//   Inside for: i = 0; 34 > 8
//     Inside for: [34, 55, 521]
//
// ...
//
// Outside for each: number = 245
//   Inside for: i = 2; 245 < 521
//   Inside for: i = 1; 245 > 55
//     Inside for: [55, 245, 521]

