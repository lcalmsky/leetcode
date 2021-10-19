package io.lcalmsky.leetcode.next_greater_element_i;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.putIfAbsent(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = findNext(nums1[i], nums2, map);
        }
        return nums1;
    }


    int findNext(int number, int[] nums2, Map<Integer, Integer> map) {
        int result = -1;
        if (map.containsKey(number)) {
            int idx = map.get(number);
            for (int j = idx + 1; j < nums2.length; j++) {
                if (nums2[j] > number) {
                    result = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
