package io.lcalmsky.leetcode.monotone_increasing_digits;

public class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        String number = String.valueOf(N);
        char[] chars = number.toCharArray();
        int length = chars.length;
        for (int i = length - 2; i >= 0; --i) {
            if (chars[i] > chars[i + 1]) {
                chars[i] = (char) (((int) chars[i]) - 1);
                for (int j = i + 1; j < length; ++j) chars[j] = '9';
            }
        }
        String newNum = String.valueOf(chars);
        int index = 0;
        while (index < newNum.length() && newNum.charAt(index) == '0') index++;
        if (index == newNum.length()) return 0;
        return Integer.parseInt(newNum.substring(index));
    }
}
