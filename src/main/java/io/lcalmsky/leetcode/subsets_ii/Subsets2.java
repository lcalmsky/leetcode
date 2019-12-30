package io.lcalmsky.leetcode.subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> prev = new ArrayList<>();
        List<Integer> temp;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1] || prev.size() == 0) {
                prev = new ArrayList<>();
                for (List<Integer> integers : result) prev.add(new ArrayList<>(integers));
            }

            for (List<Integer> integers : prev) integers.add(0, nums[i]);

            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                temp = new ArrayList<>();
                temp.add(nums[i]);
                prev.add(temp);
            }

            for (List<Integer> integers : prev) result.add(new ArrayList<>(integers));
        }

        result.add(Collections.emptyList());

        return result;
    }
}