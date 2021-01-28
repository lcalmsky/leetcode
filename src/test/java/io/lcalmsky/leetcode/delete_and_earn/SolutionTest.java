package io.lcalmsky.leetcode.delete_and_earn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenIntegers_whenPickAndDelete_thenReturnMaximumValue() {
        assertAll(
                () -> test(new int[]{3, 4, 2}, 6),
                () -> test(new int[]{2, 2, 3, 3, 3, 4}, 9)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.deleteAndEarn(given);

        // then
        assertEquals(expected, actual);
    }

}
