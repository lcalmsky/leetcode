package io.lcalmsky.leetcode.single_number;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) x ^= num;
        return x;
        // return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }
}