package io.lcalmsky.leetcode.subsets;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3}, List.of(List.of(), List.of(1), List.of(2), List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3))),
                () -> test(new int[]{0}, List.of(List.of(), List.of(0)))
        );
    }

    private void test(int[] nums, List<List<Integer>> expected) {
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.subsets(nums);
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (List<Integer> subset : expected) {
            map.put(subset, map.getOrDefault(subset, 0) + 1);
        }
        for (List<Integer> subset : actual) {
            map.put(subset, map.getOrDefault(subset, 0) - 1);
        }
        map.values().forEach(v -> assertEquals(0, v));
    }
}