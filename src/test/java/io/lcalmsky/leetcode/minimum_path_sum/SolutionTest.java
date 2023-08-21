package io.lcalmsky.leetcode.minimum_path_sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("주어진 grid 에서 왼쪽위부터 오른쪽 아래로 이동하는 경로 중 최소 합 구하기")
    public void givenGrid_whenFindMinimumPath_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                }, 7)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution minimumPathSum = new Solution();
        int actual = minimumPathSum.minPathSum(given);

        // then
        assertEquals(expected, actual);
    }
}