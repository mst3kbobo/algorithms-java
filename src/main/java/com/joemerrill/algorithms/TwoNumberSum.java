package com.joemerrill.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Two Number Sum
 * Take an array of unique integers and a target integer. If any two distinct numbers sum the target, return them as
 * an array. Otherwise, return an empty array.
 */
public class TwoNumberSum {

    public static void main(String[] args) {

        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};
        int target = 10;

        System.out.println(Arrays.toString(twoNumberSum(array, target)));
    }

    /**
     * Two Number Sum using a HashMap
     * Time: O(n) - for the traversal of the array
     * Space: O(n) - for storing the map
     * @param array
     * @param target
     * @return
     */
    public static int[] twoNumberSum(int[] array, int target) {

        int[] result = new int[2];
        HashMap<Integer, Boolean> traversed = new HashMap<Integer, Boolean>();

        for (int element : array) {
            int potentialMatch = target - element;
            if (traversed.containsKey(potentialMatch)) {
                result[0] = potentialMatch;
                result[1] = element;
                break;
            } else {
                traversed.put(element, true);
            }
        }

        return result;
    }
}
