package io.lcalmsky.leetcode.bitwise_and_of_numbers_range;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void givenNumbers_whenGetBitwiseAndOfNumbersRange_thenCorrect() {
        assertAll(
                () -> test(5, 7, 4),
                () -> test(0, 1, 0),
                () -> test(1, 2147483647, 0)
        );

    }

    private void test(int a, int b, int expected) {
        // when
        Solution bitwiseAndOfNumbersRange = new Solution();
        int actual = bitwiseAndOfNumbersRange.rangeBitwiseAnd(a, b);

        // then
        assertEquals(expected, actual);
    }
}