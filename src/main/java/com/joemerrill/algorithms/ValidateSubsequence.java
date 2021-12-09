package com.joemerrill.algorithms;

/**
 * Validate Subsequence
 * Given two non-empty arrays of integers, determine whether the second array is a subsequence of the first array.
 */
public class ValidateSubsequence {

    public static void main(String[] args) {

        int[] mainArray = new int[]{5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequenceArray = new int[]{1, 6, -1, 10};
        // Expected Result: true

        System.out.println(isValidSubsequence(mainArray, sequenceArray));
    }

    /**
     * Uses while and "Tracking" indexes to determine where we are in the arrays.
     * Time: O(n) traverse the entire main array
     * Space: O(1)
     * @param array the main array
     * @param sequence the sequence array
     * @return true if sequence array is a subsequence of the main array. Otherwise, false.
     */
    public static boolean isValidSubsequence(int[] array, int[] sequence) {

        // Edge Case: No need to do any work if the length of the sequence is greater than
        // the length of the main array because the subsequence cannot exist in this case.
        if (sequence.length > array.length) {
            return false;
        }

        // Initialize two index pointers to track positions in the array and sequence.
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while (arrayIndex < array.length && sequenceIndex < sequence.length) {

            if (sequence[sequenceIndex] == array[arrayIndex]) {
                sequenceIndex += 1;
            }
            arrayIndex += 1;
        }

        // Return true if we've traversed the entire sequence.
        return sequenceIndex == sequence.length;
    }
}
