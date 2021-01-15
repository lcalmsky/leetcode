package io.lcalmsky.leetcode.longest_increasing_path_in_a_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingPathInAMatrixTests {
    @Test
    public void givenMatrix_whenFindIncreasingPathInAMatrix_thenCorrect() {
        assertAll(
                () -> test(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 2, 1}}, 4),
                () -> test(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}, 4)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution longestIncreasingPathInAMatrix = new Solution();
        int actual = longestIncreasingPathInAMatrix.longestIncreasingPath(given);

        // then
        assertEquals(expected, actual);
    }
}
