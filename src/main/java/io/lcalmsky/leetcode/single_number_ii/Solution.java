package io.lcalmsky.leetcode.single_number_ii;

public class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three;
        for (int num : nums) {
            two = two | one & num;
            one = one ^ num;
            three = one & two;
            one = one & ~three;
            two = two & ~three;
        }
        return one;
    }
}
