package io.lcalmsky.leetcode.combination_sum_iv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombinationSum4Tests {
    @Test
    public void givenNumbers_whenFindCombination_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3}, 4, 7)
        );
    }

    private void test(int[] given, int target, int expected) {
        // when
        Solution combinationSum4 = new Solution();
        int actual = combinationSum4.combinationSUm4(given, target);

        // then
        assertEquals(expected, actual);
    }
}
