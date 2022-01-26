package com.joemerrill.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Two Number Sum: Method takes in an array of unique integers and a target integer.
 * If any two distinct numbers sum the target, return them as an array. Otherwise, return an empty array.
 */
public class TwoNumberSum {

    public static void main(String[] args) {

        int[] inputArray = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        // Expected Result: [11, -1]

        System.out.println(Arrays.toString(twoNumberSum(inputArray, targetSum)));
    }

    /**
     * Two Number Sum using a HashMap
     * Time: O(n) - for the traversal of the inputArray
     * Space: O(n) - for storing the map
     * @param inputArray an array of unique integers.
     * @param targetSum the target sum
     * @return array of the two distinct integers if found to sum the target. Otherwise, an empty array.
     */
    public static int[] twoNumberSum(int[] inputArray, int targetSum) {

        int[] result = new int[2];

        // Used to store numbers already traversed
        HashMap<Integer, Boolean> numbersTraversed = new HashMap<Integer, Boolean>();

        for (int element : inputArray) {
            int potentialSolution = targetSum - element;
            if (numbersTraversed.containsKey(potentialSolution)) {
                result[0] = potentialSolution;
                result[1] = element;
                break;
            } else {
                numbersTraversed.put(element, true);
            }
        }

        return result;
    }
}
