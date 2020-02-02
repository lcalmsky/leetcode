package io.lcalmsky.leetcode.kth_largest_element_in_an_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        Collections.sort(list);
        return list.get(list.size() - k);
    }
}
