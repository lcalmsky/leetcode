package io.lcalmsky.leetcode.next_greater_element_i;

import java.util.Arrays;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == num1) {
                    index = j;
                    break;
                }
            }
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > num1) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
