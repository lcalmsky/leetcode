package io.lcalmsky.leetcode.gas_station;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, total = 0, start = 0, remaining;
        for (int i = 0; i < gas.length; i++) {
            remaining = gas[i] - cost[i];
            if (sum >= 0) {
                sum += remaining;
            } else {
                sum = remaining;
                start = i;
            }
            total += remaining;
        }
        return total >= 0 ? start : -1;
    }
}
