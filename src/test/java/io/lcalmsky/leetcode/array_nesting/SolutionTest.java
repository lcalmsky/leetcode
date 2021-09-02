package io.lcalmsky.leetcode.array_nesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenArray_whenFindLongestLengthOfArrayNesting_thenCorrect() {
        assertAll(
                () -> test(new int[]{5, 4, 0, 3, 1, 6, 2}, 4),
                () -> test(new int[]{0, 1, 2}, 1)
        );
    }

    private void test(int[] given, int expected) {
        // when
        AnotherSolution solution = new AnotherSolution();
        int actual = solution.arrayNesting(given);

        // then
        assertEquals(expected, actual);
    }
}