package io.lcalmsky.leetcode.longest_harmonious_subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int result = 0;
        for (int num : nums) if (map.containsKey(num + 1)) result = Math.max(result, map.get(num) + map.get(num + 1));
        return result;
    }
}
