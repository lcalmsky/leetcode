package io.lcalmsky.leetcode.majority_element;

public class Solution {
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                result = num;
                count = 1;
            } else if (result == num) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }
}
