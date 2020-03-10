package io.lcalmsky.leetcode.count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) cnt++;
            }
            result.add(cnt);
        }

        return result;
    }
}
