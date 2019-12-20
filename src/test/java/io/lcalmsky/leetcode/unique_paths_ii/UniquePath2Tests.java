package io.lcalmsky.leetcode.unique_paths_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePath2Tests {
    @Test
    public void givenObstacleArray_whenFindPath_thenCorrect() {
        Assertions.assertAll(
                () -> test(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }, 2)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        UniquePath2 uniquePath2 = new UniquePath2();
        int actual = uniquePath2.uniquePathWithObstacles(given);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(actual);
    }
}
