package io.lcalmsky.leetcode._4sum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 0, -1, 0, -2, 2}, 0, Arrays.asList(
                        Arrays.asList(-2, -1, 1, 2),
                        Arrays.asList(-2, 0, 0, 2),
                        Arrays.asList(-1, 0, 0, 1)
                )),
                () -> test(new int[]{2, 2, 2, 2, 2}, 8, Collections.singletonList(Arrays.asList(2, 2, 2, 2)))
        );
    }

    private void test(int[] nums, int target, List<List<Integer>> expected) {
        // when
        List<List<Integer>> actual = solution.fourSum(nums, target);

        // then
        assertEquals(expected, actual);
    }
}