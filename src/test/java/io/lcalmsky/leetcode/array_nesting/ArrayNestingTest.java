package io.lcalmsky.leetcode.array_nesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayNestingTest {
    @Test
    public void givenArray_whenFindLongestLengthOfArrayNesting_thenCorrect() {
        assertAll(
                () -> test(new int[]{5, 4, 0, 3, 1, 6, 2}, 4, new Solution()),
                () -> test(new int[]{5, 4, 0, 3, 1, 6, 2}, 4, new AnotherSolution())
        );
    }

    private void test(int[] given, int expected, ArrayNesting arrayNesting) {
        // when
        int actual = arrayNesting.arrayNesting(given);

        // then
        assertEquals(expected, actual);
    }
}