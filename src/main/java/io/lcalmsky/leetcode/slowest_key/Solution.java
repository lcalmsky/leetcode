package io.lcalmsky.leetcode.slowest_key;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxReleaseTime = releaseTimes[0];
        int maxIndex = 0;
        for (int i = 1; i < releaseTimes.length; i++) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > maxReleaseTime) {
                maxIndex = i;
                maxReleaseTime = diff;
            } else if (diff == maxReleaseTime) {
                maxIndex = keysPressed.charAt(maxIndex) > keysPressed.charAt(i) ? maxIndex : i;
            }
        }
        return keysPressed.charAt(maxIndex);
    }
}