package io.lcalmsky.leetcode.shortest_subarray_with_sum_at_least_k;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenArray_whenFindShortestSubArrayOfArrayWithSumAtLeastK_thenCorrect() {
        assertAll(
                () -> test(new int[]{1}, 1, 1),
                () -> test(new int[]{1, 2}, 4, -1),
                () -> test(new int[]{2, -1, 2}, 3, 3)
        );
    }

    private void test(int[] given, int k, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.shortestSubarray(given, k);

        // then
        assertEquals(expected, actual);
    }
}
