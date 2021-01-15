package io.lcalmsky.leetcode.foursum_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourSum2Tests {
    @Test
    public void given4Pairs_whenCountSumEqualsZero_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2)
        );
    }

    private void test(int[] a, int[] b, int[] c, int[] d, int expected) {
        // when
        Solution fourSum2 = new Solution();
        int actual = fourSum2.fourSumCount(a, b, c, d);

        // then
        assertEquals(expected, actual);
    }
}
