package io.lcalmsky.leetcode.shortest_distance_to_a_character;

public class Solution {
    public int[] shortestToChar(String s, char c) {
        int length = s.length();
        int[] result = new int[length];
        int prev = -0x3f3f3f3f;

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == c) prev = i;
            result[i] = i - prev;
        }

        prev = 0x3f3f3f3f;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == c) prev = i;
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }
}
