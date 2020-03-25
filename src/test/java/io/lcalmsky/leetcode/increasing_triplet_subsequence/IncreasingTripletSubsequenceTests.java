package io.lcalmsky.leetcode.increasing_triplet_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncreasingTripletSubsequenceTests {
    @Test
    public void givenNumbers_whenFindIncreasingTripletSubsequence_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4, 5}, true),
                () -> test(new int[]{5, 4, 3, 2, 1}, false)
        );
    }

    private void test(int[] given, boolean expected) {
        // when
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        boolean actual = increasingTripletSubsequence.increasingTriplet(given);

        // then
        assertEquals(expected, actual);
    }
}
