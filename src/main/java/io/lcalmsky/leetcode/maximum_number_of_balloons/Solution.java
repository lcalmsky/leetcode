package io.lcalmsky.leetcode.maximum_number_of_balloons;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] alphabets = new int[26];
        for (char c : text.toCharArray()) {
            alphabets[c - 'a']++;
        }
        int max = alphabets[0];
        return Math.min(Math.min(Math.min(Math.min(max, alphabets[1]), alphabets[11] / 2), alphabets[14] / 2), alphabets[13]);
    }
}