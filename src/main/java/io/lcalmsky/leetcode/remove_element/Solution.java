package io.lcalmsky.leetcode.remove_element;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[cnt] = nums[i];
                cnt++;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
        return cnt;
    }
}
