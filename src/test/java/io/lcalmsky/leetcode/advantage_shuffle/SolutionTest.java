package io.lcalmsky.leetcode.advantage_shuffle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void givenArrays_whenMaximizeAdvantage_thenCorrect() {
        assertAll(
                () -> test(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}, new int[]{2, 11, 7, 15}),
                () -> test(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11}, new int[]{24, 32, 8, 12})
        );
    }

    private void test(int[] A, int[] B, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.advantageCount(A, B);

        // then
        assertArrayEquals(expected, actual);
    }
}