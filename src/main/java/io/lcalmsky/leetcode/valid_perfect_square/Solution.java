package io.lcalmsky.leetcode.valid_perfect_square;

/**
 * <pre>
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 * </pre>
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int i = -1;
        while (num > 0) {
            num -= i += 2;
        }
        return num == 0;
    }
}
