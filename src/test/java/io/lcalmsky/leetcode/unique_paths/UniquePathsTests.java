package io.lcalmsky.leetcode.unique_paths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePathsTests {

    @Test
    public void givenMatrixSize_whenCountUniquePaths_thenCorrect() {
        assertAll(
                () -> test(3, 2, 3),
                () -> test(7, 3, 28)
        );
    }

    public void test(int givenN, int givenM, int expected) {
        // when
        Solution uniquePaths = new Solution();
        int actual = uniquePaths.uniquePaths(givenN, givenM);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(actual);
    }
}
