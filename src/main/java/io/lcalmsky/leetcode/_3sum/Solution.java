package io.lcalmsky.leetcode._3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        int low = 0;
        while (low < nums.length - 2) {
            int mid = low + 1, high = nums.length - 1;
            while (mid < high) {
                int sum = nums[low] + nums[mid] + nums[high];
                if (sum == 0) {
                    result.add(List.of(nums[low], nums[mid], nums[high]));
                }
                if (sum <= 0) {
                    while (nums[mid] == nums[++mid] && mid < high) ;
                }
                if (sum >= 0) {
                    while (nums[high--] == nums[high] && mid < high) ;
                }
            }
            while (nums[low] == nums[++low] && low < nums.length - 2) ;
        }
        return result;
    }
}
