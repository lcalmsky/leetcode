package io.lcalmsky.leetcode.shifting_letters;

public class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int length = shifts.length;
        long[] cumulativeValues = new long[length];
        cumulativeValues[length - 1] = shifts[length - 1];
        for (int i = length - 2; i >= 0; i--) cumulativeValues[i] = shifts[i] + cumulativeValues[i + 1];
        char[] chars = S.toCharArray();
        for (int i = 0; i < length; i++) {
            chars[i] += cumulativeValues[i] % 26;
            if (chars[i] > 'z') chars[i] -= 26;
        }
        return new String(chars);
    }
}
