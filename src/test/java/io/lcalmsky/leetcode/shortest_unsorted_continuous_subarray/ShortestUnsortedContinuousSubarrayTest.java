package io.lcalmsky.leetcode.shortest_unsorted_continuous_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestUnsortedContinuousSubarrayTest {
    @Test
    public void givenArray_whenFindTheShortestSubarrayLength_thenCorrect() {
        assertAll(
                () -> test(new int[]{2, 6, 4, 8, 10, 9, 15}, 5),
                () -> test(new int[]{1, 2, 3, 4}, 0)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution shortestUnsortedContinuousSubarray = new Solution();
        int actual = shortestUnsortedContinuousSubarray.findUnsortedSubarray(given);

        // then
        assertEquals(expected, actual);
    }

}
