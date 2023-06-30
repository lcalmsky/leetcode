package io.lcalmsky.leetcode.jump_game_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{2, 3, 1, 1, 4}, 2),
                () -> test(new int[]{2, 3, 0, 1, 4}, 2)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.jump(nums);
        // then
        assertEquals(expected, actual);
    }
}