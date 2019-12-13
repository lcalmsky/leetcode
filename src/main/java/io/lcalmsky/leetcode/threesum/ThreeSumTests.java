package io.lcalmsky.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumTests {

    public static void main(String[] args) {
        ThreeSumTests threeSumTests = new ThreeSumTests();
        System.out.println(threeSumTests.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int start, end;
        List<Integer> list = null;
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            end = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            while (start < end) {
                if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                    continue;
                }
                if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                    continue;
                }
                list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[start]);
                list.add(nums[end]);
                result.add(list);
                start++;
                end--;
            }
        }

        return result;
    }
}