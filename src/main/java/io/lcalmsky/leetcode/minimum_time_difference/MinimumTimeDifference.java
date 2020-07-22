package io.lcalmsky.leetcode.minimum_time_difference;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 * </pre>
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] minuteArray = new int[timePoints.size()];
        for (int i = 0; i < minuteArray.length; i++) {
            minuteArray[i] = transToMinute(timePoints.get(i));
        }
        Arrays.sort(minuteArray);

        int min = 24 * 60 - minuteArray[minuteArray.length - 1] + minuteArray[0];
        for (int i = 0; i < minuteArray.length - 1; i++) {
            if (minuteArray[i + 1] - minuteArray[i] < min) min = minuteArray[i + 1] - minuteArray[i];
        }
        return min;
    }

    public int transToMinute(String time) {
        String[] arr = time.split(":");
        int a = Integer.parseInt(arr[0]) * 60;
        int b = Integer.parseInt(arr[1]);
        return a + b;
    }
}
