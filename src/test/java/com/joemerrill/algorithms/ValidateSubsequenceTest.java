package com.joemerrill.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateSubsequenceTest {

    @Test
    void validateSubsequenceTest() {

        ValidateSubsequence vs = new ValidateSubsequence();
        assertEquals(true,
                vs.validateSubsequence(new int[]{5, 1, 22, 25, 6, -1, 8, 10}, new int[]{1, 6, -1, 10})
        );
        assertEquals(false,
                vs.validateSubsequence(new int[]{5, 1, 22, 25, 18, -1, 8, 10}, new int[]{1, 6, -1, 10})
        );
        assertEquals(true, vs.validateSubsequence(new int[]{5, 1}, new int[]{5, 1}));
        assertEquals(false, vs.validateSubsequence(new int[]{5, 1}, new int[]{5, 1, 8, 16}));
    }
}