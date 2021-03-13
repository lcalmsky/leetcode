package io.lcalmsky.leetcode.positions_of_large_groups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        int start = 0, end = 0, count = 1;
        char previous = s.charAt(0), current;
        for (int i = 1; i < s.length(); i++) {
            current = s.charAt(i);
            if (previous == current) {
                count++;
                end = i;
            } else {
                if (count >= 3) result.add(Arrays.asList(start, end));
                count = 1;
                start = i;
            }
            previous = current;
        }
        if (count >= 3) result.add(Arrays.asList(start, end));
        return result;
    }
}
