package io.lcalmsky.leetcode.power_of_four;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        int count0 = 0;
        int count1 = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                count1++;
            } else {
                count0++;
            }

            num >>= 1;
        }

        return count1 == 1 && (count0 % 2 == 0);
    }
}