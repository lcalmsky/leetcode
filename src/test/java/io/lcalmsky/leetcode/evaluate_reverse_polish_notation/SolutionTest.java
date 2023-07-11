package io.lcalmsky.leetcode.evaluate_reverse_polish_notation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new String[]{"2", "1", "+", "3", "*"}, 9),
                () -> test(new String[]{"4", "13", "5", "/", "+"}, 6),
                () -> test(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }

    private void test(String[] tokens, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.evalRPN(tokens);
        // then
        assertEquals(expected, actual);
    }

}