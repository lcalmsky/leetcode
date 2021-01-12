package io.lcalmsky.leetcode.base_7;

/**
 * <pre>
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 * </pre>
 */
public class Solution {
    public String convertToBase7(int num) {
        int abs = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (abs >= 7) {
            sb.append(abs % 7);
            abs /= 7;
        }
        sb.append(abs).reverse();
        return num >= 0 ? sb.toString() : sb.insert(0, "-").toString();
    }
}
