package io.lcalmsky.leetcode.maximum_gap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumGapTests {
    @Test
    public void givenArray_whenFindMaximumGap_thenCorrect() {
        assertAll(
                () -> test(new int[]{3, 6, 9, 1}, 3),
                () -> test(new int[]{10}, 0)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution maximumGap = new Solution();
        int actual = maximumGap.maximumGap(given);

        // then
        assertEquals(expected, actual);
    }
}
