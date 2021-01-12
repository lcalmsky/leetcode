package io.lcalmsky.leetcode.largest_number;

import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums) {

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        StringBuilder sb = new StringBuilder();
        for (String str : strs) sb.append(str);

        while (sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);

        return sb.toString();
    }
}
