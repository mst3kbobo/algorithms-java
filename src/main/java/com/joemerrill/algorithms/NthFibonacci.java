package com.joemerrill.algorithms;

/**
 * Get the Nth number from the Fibonacci Sequence.
 * For example, the 9th (N) number in the sequence is 21.
 */
public class NthFibonacci {

    public static void main(String[] args) {

        int targetIterative = 9;
        int resultIterative = nthFibonacciIterative(targetIterative);

        System.out.println("The " + targetIterative +
                " number in the Fibonacci Sequence is " +
                resultIterative + ".");


    }

    /**
     * Find the Nth number from the Fibonacci Sequence using an iterative approach.
     * Complexity Analysis:
     * - Time: O(n) for the loop until the requested number
     * - Space: O(1)
     * @param number Nth number in the sequence to find
     * @return value of the integer at Nth position in the sequence.
     */
    public static int nthFibonacciIterative(int number) {

        int[] lastTwo = {0, 1}; // Tracking array - Populated with first two numbers in Fib sequence
        int counter = 3; // The next number in the sequence to calculate

        // Loop while the counter is less than or equal to the target number passed to the method.
        // Set the Tracking array to the next numbers and increment the counter.
        while (counter <= number) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter += 1;
        }

        // Edge case if the first number in the sequence is requested.
        if (number > 1) {
            return lastTwo[1];
        } else {
            return lastTwo[0];
        }
    }

}
