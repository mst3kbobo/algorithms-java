package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NthFibonacciTest {

    @Test
    void nthFibonacciIterative() {
        assertEquals(0, NthFibonacci.nthFibonacciIterative(1));
        assertEquals(1, NthFibonacci.nthFibonacciIterative(2));
        assertEquals(21, NthFibonacci.nthFibonacciIterative(9));
        assertEquals(89, NthFibonacci.nthFibonacciIterative(12));
    }
}