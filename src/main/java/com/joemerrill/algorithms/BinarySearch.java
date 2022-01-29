package com.joemerrill.algorithms;

import java.util.Arrays;

/**
 * This program demonstrates a Binary Search algorithm.
 * The method take a sorted array of integers and a target integer.
 * Returns the index of the target if it's contained in the array. Returns -1 if not.
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {3, 6, 8, 10, 12, 33, 39, 40, 67};

        System.out.println("array: " + Arrays.toString(array));
        System.out.println("8 is located at index " + binarySearch(array, 8) + ".");
        System.out.println("200 is located at index " + binarySearch(array, 200) + ".");
    }

    /**
     * Binary Search Algorithm
     * Complexity Analysis:
     * - Time: O(log(n)) for division of array at each pass
     * - Space: O(1)
     * @param array sorted input array
     * @param target target integer to find in the input array
     * @return index of target if found in input array. -1 if not found.
     */
    public static int binarySearch(int[] array, int target) {

        // Variables for indexes to keep track of left and right "pointers" on the array as we divide and conquer it.
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex) {

            // Find middle element of the array to see if it's == to, <, or > the target.
            int middleIndex = (leftIndex + rightIndex) / 2;
            int potentialMatch = array[middleIndex];

            if (target == potentialMatch) {
                return middleIndex;
            } else if (target < potentialMatch) {
                rightIndex = middleIndex - 1;
            } else if (target > potentialMatch) {
                leftIndex = middleIndex + 1;
            }
        }

        // Base case (target not found in array)
        return -1;
    }
}

// Validation
//  0  1  2   3   4   5   6   7   8     array indices
// [3, 6, 8, 10, 12, 33, 39, 40, 67]    array
//  8                                   target
//
// Loop Pass 1 => leftIndex 0; rightIndex 8; middleIndex 4; potentialMatch 12; > target
// Loop Pass 2 => leftIndex 0; rightIndex 3; middleIndex 1; potentialMatch  6; < target
// Loop Pass 3 => leftIndex 2; rightIndex 3; middleIndex 2; potentialMatch  8; == target
