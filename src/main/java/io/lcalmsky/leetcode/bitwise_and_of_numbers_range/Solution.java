package io.lcalmsky.leetcode.bitwise_and_of_numbers_range;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }
        return m & n;
    }
}
