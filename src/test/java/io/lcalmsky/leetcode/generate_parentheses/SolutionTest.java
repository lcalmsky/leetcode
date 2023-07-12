package io.lcalmsky.leetcode.generate_parentheses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                () -> test(1, List.of("()"))
        );
    }

    private void test(int n, List<String> expected) {
        // when
        Solution solution = new Solution();
        List<String> actual = solution.generateParenthesis(n);
        // then
        assertEquals(expected, actual);
    }
}