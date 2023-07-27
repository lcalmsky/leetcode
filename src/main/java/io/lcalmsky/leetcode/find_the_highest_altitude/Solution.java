package io.lcalmsky.leetcode.find_the_highest_altitude;

public class Solution {
    public int largestAltitude(int[] gain) {
        int net = 0;
        int max = net;
        for (int i : gain) {
            net += i;
            max = Math.max(net, max);
        }
        return max;
    }
}
