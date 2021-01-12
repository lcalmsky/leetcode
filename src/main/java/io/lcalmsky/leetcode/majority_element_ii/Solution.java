package io.lcalmsky.leetcode.majority_element_ii;

import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null) return Collections.emptyList();
        int major = nums.length / 3;
        System.out.println(major);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        map.keySet().stream().filter(k -> map.get(k) > major).forEach(result::add);

        return result;
    }
}
