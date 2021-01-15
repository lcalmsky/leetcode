package io.lcalmsky.leetcode.monotone_increasing_digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenNumber_whenFindMonotoneIncreaseNumber_thenCorrect() {
        assertAll(
                () -> test(10, 9),
                () -> test(1234, 1234),
                () -> test(332, 299)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.monotoneIncreasingDigits(given);

        // then
        assertEquals(expected, actual);
    }
}
