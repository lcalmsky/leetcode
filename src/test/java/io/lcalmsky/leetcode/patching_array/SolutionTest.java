package io.lcalmsky.leetcode.patching_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenArray_whenAddOrPatchSomeIntegers_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3}, 6, 1),
                () -> test(new int[]{1, 5, 10}, 20, 2),
                () -> test(new int[]{1, 2, 2}, 5, 0)
        );
    }

    private void test(int[] givenArray, int givenNumber, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.minPatches(givenArray, givenNumber);

        // then
        assertEquals(expected, actual);
    }
}