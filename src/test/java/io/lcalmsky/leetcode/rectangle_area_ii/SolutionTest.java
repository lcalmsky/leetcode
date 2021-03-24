package io.lcalmsky.leetcode.rectangle_area_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenRectangles_whenFindTotalArea_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {0, 0, 2, 2},
                        {1, 0, 2, 3},
                        {1, 0, 3, 1}
                }, 6),
                () -> test(new int[][]{
                        {0, 0, 1000000000, 1000000000}
                }, 49)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.rectangleArea(given);

        // then
        assertEquals(expected, actual);
    }
}
