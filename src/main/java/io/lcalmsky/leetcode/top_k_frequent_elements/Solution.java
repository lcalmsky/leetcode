package io.lcalmsky.leetcode.top_k_frequent_elements;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * </pre>
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        return map.keySet().stream()
                .sorted((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)))
                .limit(k)
                .collect(Collectors.toList());
    }
}
