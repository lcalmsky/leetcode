package io.lcalmsky.leetcode.remove_k_digits;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <pre>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * </pre>
 */
public class Solution {
    public String removeKDigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        while (k-- > 0) deque.removeLast();
        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (char c : deque) {
            if (isZero && c == '0') continue;
            isZero = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
