package io.lcalmsky.leetcode.majority_element;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major = nums.length / 2 + 1;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        return countMap.keySet().stream().filter(k -> countMap.get(k) >= major).findFirst().orElse(-1);
    }
}
