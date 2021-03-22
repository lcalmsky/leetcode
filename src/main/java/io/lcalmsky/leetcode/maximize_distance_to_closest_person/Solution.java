package io.lcalmsky.leetcode.maximize_distance_to_closest_person;

public class Solution {
    public int maxDistToClosest(int[] seats) {
        int leftMax = 0;
        int rightMax = 0;
        for (int seat : seats) {
            if (seat != 0) break;
            leftMax++;
        }
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] != 0) break;
            rightMax++;
        }
        int max = Math.max(leftMax, rightMax);
        int count = 0;
        for (int i = leftMax; i < seats.length - rightMax; i++) {
            count++;
            if (seats[i] == 1) {
                max = Math.max(max, count / 2);
                count = 0;
            }
        }
        return max;
    }
}
