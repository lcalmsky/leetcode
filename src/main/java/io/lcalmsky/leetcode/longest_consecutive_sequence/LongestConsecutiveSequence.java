package io.lcalmsky.leetcode.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longestConsecutiveSequence = 0;
        int count, down, up;
        for (int num : nums) {
            count = 1;
            down = num - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
                count++;
            }
            up = num + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
                count++;
            }
            longestConsecutiveSequence = Math.max(longestConsecutiveSequence, count);
        }
        return longestConsecutiveSequence;
    }
}
