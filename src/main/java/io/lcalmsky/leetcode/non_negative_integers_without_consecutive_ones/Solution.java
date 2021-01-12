package io.lcalmsky.leetcode.non_negative_integers_without_consecutive_ones;

/**
 * <pre>
 * Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.
 *
 * Example 1:
 * Input: 5
 * Output: 5
 * Explanation:
 * Here are the non-negative integers <= 5 with their corresponding binary representations:
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 * Note: 1 <= n <= 10^9
 * </pre>
 */
public class Solution {
    public int findIntegers(int num) {
        if (num < 0) return 0;

        String bit = toBinary(num);
        int length = bit.length();

        int[] ones = new int[length];
        int[] zeroes = new int[length];
        ones[0] = 1;
        zeroes[0] = 1;

        for (int i = 1; i < length; i++) {
            zeroes[i] = ones[i - 1] + zeroes[i - 1];
            ones[i] = zeroes[i - 1];
        }

        int total = ones[length - 1] + zeroes[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            if (bit.charAt(i) == '1' && bit.charAt(i + 1) == '1') break;
            if (bit.charAt(i) == '0' && bit.charAt(i + 1) == '0') total -= ones[i];
        }
        return total;
    }

    private String toBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if ((num & 1) == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            num >>>= 1;
        }
        return sb.toString();
    }
}
