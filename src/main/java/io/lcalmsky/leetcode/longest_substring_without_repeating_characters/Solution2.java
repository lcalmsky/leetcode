package io.lcalmsky.leetcode.longest_substring_without_repeating_characters;

public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int[] visited = new int[96];
        for (int end = 0; end < s.length(); end++) {
            int current = s.charAt(end) - 32;
            start = Math.max(visited[current], start);
            max = Math.max(max, end - start + 1);
            visited[current] = end + 1;
        }
        return max;
    }
}
