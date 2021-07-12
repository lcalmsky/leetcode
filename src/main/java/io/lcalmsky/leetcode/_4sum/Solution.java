package io.lcalmsky.leetcode._4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int rest = target - nums[i] - nums[j];
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == rest) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        result.add(tmp);
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < rest) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
