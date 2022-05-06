package io.lcalmsky.leetcode.maxmimum_length_of_pair_chain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumLengthOfPairChainTest {
    @Test
    public void givenPairArray_whenFindMaximumLengthOfPairChain_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {1, 2},
                        {2, 3},
                        {3, 4}
                }, 2)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution maximumLengthOfPairChain = new Solution();
        int actual = maximumLengthOfPairChain.findLongestChain(given);

        // then
        assertEquals(expected, actual);
    }

}
