package io.lcalmsky.leetcode.shifting_letters;

public class Solution {
//    public String shiftingLetters(String s, int[] shifts) {
//        int length = shifts.length;
//        long[] cumulativeValues = new long[length];
//        cumulativeValues[length - 1] = shifts[length - 1];
//        for (int i = length - 2; i >= 0; i--) {
//            cumulativeValues[i] = shifts[i] + cumulativeValues[i + 1];
//        }
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < length; i++) {
//            chars[i] += cumulativeValues[i] % 26;
//            if (chars[i] > 'z') {
//                chars[i] -= 26;
//            }
//        }
//        return new String(chars);
//    }
    public String shiftingLetters(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1] % 26;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < shifts.length; i++) {
            chars[i] += shifts[i] % 26;
            if (chars[i] > 'z') {
                chars[i] -= 26;
            }
        }
        return new String(chars);
    }
}
