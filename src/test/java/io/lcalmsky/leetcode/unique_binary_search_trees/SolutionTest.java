package io.lcalmsky.leetcode.unique_binary_search_trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testAll() {
        assertAll(
                () -> test(3, 5),
                () -> test(1, 1),
                () -> test(4, 14)
        );
    }

    private void test(int given, int expected) {
        // when
        int actual = solution.numTrees(given);

        // then
        assertEquals(expected, actual);
    }
}