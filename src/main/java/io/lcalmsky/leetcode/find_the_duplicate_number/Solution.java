package io.lcalmsky.leetcode.find_the_duplicate_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) return i;
        }
        return -1;
    }
}
