package io.lcalmsky.leetcode.rectangle_overlap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTwoRectangles_whenOverlay_thenReturnsTrue() {
        assertAll(
                () -> test(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}, true),
                () -> test(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}, false),
                () -> test(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3}, false),
                () -> test(new int[]{-1, 0, 1, 1}, new int[]{0, -1, 0, 1}, false)
        );
    }

    private void test(int[] rec1, int[] rec2, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.isRectangleOverlap(rec1, rec2);

        // then
        assertEquals(expected, actual);
    }
}