package io.lcalmsky.leetcode.threesum_closest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int start, end, sum, tmp;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            end = nums.length - 1;
            tmp = nums[i];
            while (start < end) {
                if (tmp == nums[start++]) {
                    continue;
                }
                if (tmp == nums[end--]) {
                    continue;
                }
                sum = tmp + nums[start] + nums[end];
                System.out.printf("%d=%d+%d+%d\n", sum, tmp, nums[start], nums[end]);
                if (sum == target) return target;
                list.add(sum);
                if (sum < target) {
                    start++;
                    continue;
                }
                if (sum > target) {
                    end--;
                    continue;
                }
            }
        }

        Collections.sort(list);

        return list.stream().min((o1, o2) -> Integer.compare(Math.abs(o1 - target), Math.abs(o2 - target))).get();
    }
}
