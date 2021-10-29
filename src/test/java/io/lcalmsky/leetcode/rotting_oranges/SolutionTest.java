package io.lcalmsky.leetcode.rotting_oranges;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    @DisplayName("그리드가 주어졌을 때 오렌지가 모두 썩는 시간을 구함")
    void test() {
        assertAll(
            () -> test(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}, 4),
            () -> test(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}, -1),
            () -> test(new int[][]{{0, 2}}, 0)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.orangesRotting(given);
        // then
        assertEquals(expected, actual);
    }
}