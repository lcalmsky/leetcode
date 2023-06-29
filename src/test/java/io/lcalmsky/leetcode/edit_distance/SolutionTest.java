package io.lcalmsky.leetcode.edit_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("horse", "ros", 3),
                () -> test("intention", "execution", 5)
        );
    }

    private void test(String word1, String word2, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.minDistance(word1, word2);
        // then
        assertEquals(expected, actual);
    }
}