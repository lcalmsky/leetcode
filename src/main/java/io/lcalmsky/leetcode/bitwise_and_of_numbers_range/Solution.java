package io.lcalmsky.leetcode.bitwise_and_of_numbers_range;

public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int move = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            move++;
        }
        return right << move;
    }
}
