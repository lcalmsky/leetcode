package io.lcalmsky.leetcode.longest_mountain_in_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenMountainArray_whenReturnTheLengthOfTheLongestMountain_thenCorrect() {
        assertAll(
                () -> test(new int[]{2, 1, 4, 7, 3, 2, 5}, 5),
                () -> test(new int[]{2, 2, 2}, 0)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.longestMountain2(given);

        // then
        assertEquals(expected, actual);
    }
}
