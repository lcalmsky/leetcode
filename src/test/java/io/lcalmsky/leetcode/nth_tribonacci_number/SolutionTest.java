package io.lcalmsky.leetcode.nth_tribonacci_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void givenNumber_whenFindTribonacci_thenCorrect() {
        assertAll(
                () -> test(4, 4),
                () -> test(25, 1389537)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.tribonacci(given);

        // then
        assertEquals(expected, actual);
    }
}