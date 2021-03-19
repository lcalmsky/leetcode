package io.lcalmsky.leetcode.longest_mountain_in_array;

public class Solution {
    public int longestMountain(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) continue;
            int increasingLength = 0;
            while (i < arr.length && arr[i] > arr[i - 1]) {
                increasingLength++;
                i++;
            }
            int decreasingLength = 0;
            for (int j = i; j < arr.length && arr[j - 1] > arr[j]; j++) {
                decreasingLength++;
                result = Math.max(result, increasingLength + decreasingLength + 1);
                i = j;
            }
        }
        return result;
    }

    public int longestMountain2(int[] arr) {
        int result = 0, len = arr.length;
        for (int i = 1; i < len - 1; ++i) {
            if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                int left = i - 1, right = i + 1;
                while (left > 0 && arr[left - 1] < arr[left]) --left;
                while (right < len - 1 && arr[right] > arr[right + 1]) ++right;
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}
