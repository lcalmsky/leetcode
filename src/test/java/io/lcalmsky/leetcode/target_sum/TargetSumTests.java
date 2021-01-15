package io.lcalmsky.leetcode.target_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TargetSumTests {
    @Test
    public void givenArray_whenCountNumberOfWays_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 1, 1, 1, 1}, 3, 5)
        );
    }

    private void test(int[] given, int target, int expected) {
        // when
        Solution targetSum = new Solution();
        int actual = targetSum.findTargetSumWays(given, target);

        // then
        assertEquals(expected, actual);
    }
}
