package io.lcalmsky.leetcode.find_k_th_smallest_pair_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenIntegerArray_whenFindKThSmallestDistanceAmongAllPairs_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 1}, 1, 0)
        );
    }

    private void test(int[] nums, int k, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.smallestDistancePair(nums, k);

        // then
        assertEquals(expected, actual);
    }
}
