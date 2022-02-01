package com.joemerrill.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This program demonstrates a Three Number Sum algorithm.
 */
public class ThreeNumberSum {

    public static void main(String[] args) {

        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int target = 0;
        int[][] expectedResult = {{-8, 2, 6}, {-8, 3, 5}, {-6, 1, 5}};

        int[][] test = threeNumberSum(array, target);

        System.out.println("Expected Result: " + Arrays.deepToString(expectedResult));
        System.out.println("  Actual Result: " + Arrays.deepToString(test));
    }

    /**
     * Three Number Sum Algorithm. The method takes an array of integers and a target integer.
     * Find all triplets in the array that sum the target. Return each triplet as an array in an array.
     * Complexity Analysis:
     * - Time: O(n^2)
     * - Space: O(n)
     * @param array array of integers
     * @param target target integer
     * @return array of array
     */
    public static int[][] threeNumberSum(int[] array, int target) {

        // First sort the array
        Arrays.sort(array);

        List<int[]> arraySums = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {

            // Create "pointers" for the 3 numbers to sum (current i; left i + 1; right last index of array)
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {

                int currentSum = array[i] + array[left] + array[right];

                if (currentSum == target) {
                    // Found a match. Add this triplet, move left and right "pointers", and check next iteration.
                    arraySums.add(new int[] {array[i], array[left], array[right]});
                    left += 1;
                    right -= 1;
                } else if (currentSum < target) {
                    left += 1; // Increase next iteration's sum by moving the left "pointer" up in the sorted array.
                } else if (currentSum > target) {
                    right -= 1; // Decrease next iteration's sum by moving the right "pointer" down in the sorted array.
                }

            }
        }

        // Convert arraySums to int[][] and return
        int[][] result = new int[arraySums.size()][3];
        return arraySums.toArray(result);
    }
}

// Test
//   0,  1, 2, 3, 4, 5, 6,  7  Indices
// [-8, -6, 1, 2, 3, 5, 6, 12] sorted array
// 0 is target
//
// Iterations:
// ----------
// 1st for (i = 0)
//   1st while:   i   l                 r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-8 + -6 + 12) == -2 < target --> move l
//   2nd while:   i      l              r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-8 + 1 + 12) == 5 > target --> move r
//   3rd while:   i      l           r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-8 + 1 + 6) == -1 < target --> move l
//   4th while:   i         l        r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-8 + 2 + 6) == 0 == target --> add match, move l & r
//   5th while:   i            l  r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-8 + 3 + 5) == 0 == target --> add match, move l & r
//              l no longer < r, exit while
// 2nd for (i = 1)
//   1st while:       i  l              r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-6 + 1 + 12) == 7 > target --> move r
//   2nd while:       i  l           r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-6 + 1 + 6) == 1 > target --> move r
//   3rd while:       i  l        r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-6 + 1 + 5) == 0 == target --> add match, move l & r
//   4th while:       i     l  r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (-6 + 2 + 3) == -1 < target --> move l
//              l no longer < r, exit while
// 3rd for (i = 2)
//   1st while:          i  l           r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (1 + 2 + 12) == 15 > target --> move r
//   2nd while:          i  l        r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (1 + 2 + 6) == 9 > target --> move r
//   3rd while:          i  l     r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (1 + 2 + 5) == 8 > target --> move r
//   4th while:          i  l  r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (1 + 2 + 3) == 6 > target --> move r
//              l no longer < r, exit while
// 4th for (i = 3)
//   1st while:             i  l        r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (2 + 3 + 12) == 17 > target --> move r
//   2nd while:             i  l     r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (2 + 3 + 6) == 11 > target --> move r
//   3rd while:             i  l  r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (2 + 3 + 5) == 10 > target --> move r
//              l no longer < r, exit while
// 5th for (i = 4)
//   1st while:                i  l     r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (3 + 5 + 12) == 20 > target --> move r
//   2nd while:                i  l  r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (3 + 5 + 6) == 14 > target --> move r
//              l no longer < r, exit while
// 6th for (i = 5)
//   1st while:                   i  l  r
//              [-8, -6, 1, 2, 3, 5, 6, 12] (5 + 6 + 12) == 23 > target --> move r
//              l no longer < r, exit while
//   i no longer < (array.length - 2), exit for loop
