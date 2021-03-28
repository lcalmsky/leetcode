package io.lcalmsky.leetcode.lemonade_change;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenCustomers_whenProvideChanges_thenCorrect() {
        assertAll(
                () -> test(new int[]{5, 5, 5, 10, 20}, true),
                () -> test(new int[]{5, 5, 10}, true),
                () -> test(new int[]{10, 10}, false),
                () -> test(new int[]{5, 5, 10, 10, 20}, false)
        );
    }

    private void test(int[] given, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.lemonadeChange(given);

        // then
        assertEquals(expected, actual);
    }
}