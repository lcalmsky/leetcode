package io.lcalmsky.leetcode.flipping_an_image;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void givenBinaryMatrixImage_whenFlipTheImageHorizontallyAndInvert_thenCorrect() {
        assertAll(
                () -> test(
                        new int[][]{
                                {1, 1, 0},
                                {1, 0, 1},
                                {0, 0, 0}
                        }, new int[][]{
                                {1, 0, 0},
                                {0, 1, 0},
                                {1, 1, 1}
                        }),
                () -> test(
                        new int[][]{
                                {1, 1, 0, 0},
                                {1, 0, 0, 1},
                                {0, 1, 1, 1},
                                {1, 0, 1, 0}
                        },
                        new int[][]{
                                {1, 1, 0, 0},
                                {0, 1, 1, 0},
                                {0, 0, 0, 1},
                                {1, 0, 1, 0}
                        })

        );
    }

    private void test(int[][] given, int[][] expected) {
        // when
        Solution solution = new Solution();
        int[][] actual = solution.flipAndInvertImage(given);

        // then
        assertArrayEquals(expected, actual);
    }

}
