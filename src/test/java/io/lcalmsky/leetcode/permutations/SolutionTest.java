package io.lcalmsky.leetcode.permutations;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3}, List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1))),
                () -> test(new int[]{0, 1}, List.of(List.of(0, 1), List.of(1, 0))),
                () -> test(new int[]{1}, List.of(List.of(1)))
        );
    }

    private void test(int[] nums, List<List<Integer>> expected) {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.permute(nums);
        Set<List<Integer>> expectedSet = new HashSet<>(expected);
        Set<List<Integer>> actualSet = new HashSet<>(actual);
        assertTrue(expectedSet.containsAll(actualSet));
    }
}