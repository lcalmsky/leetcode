package io.lcalmsky.leetcode.longest_turbulent_subarray;

public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int increase = 1, decrease = 1, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                decrease = increase + 1;
                increase = 1;
            } else if (arr[i] > arr[i - 1]) {
                increase = decrease + 1;
                decrease = 1;
            } else {
                increase = 1;
                decrease = 1;
            }
            count = Math.max(count, Math.max(increase, decrease));
        }
        return count;
    }
}

class BetterRuntimeSolution extends Solution {
    @Override
    public int maxTurbulenceSize(int[] arr) {
        int increase = 1, decrease = 1, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                decrease = increase + 1;
                increase = 1;
                count = Math.max(count, decrease);
            } else if (arr[i] > arr[i - 1]) {
                increase = decrease + 1;
                decrease = 1;
                count = Math.max(count, increase);
            } else {
                increase = 1;
                decrease = 1;
            }
        }
        return count;
    }
}

class BetterMemorySolution extends Solution {
    @Override
    public int maxTurbulenceSize(int[] arr) {
        int length = arr.length;
        if (length < 2) return length;
        int count = 1;
        int[] increase = new int[length];
        int[] decrease = new int[length];
        increase[0] = 1;
        decrease[0] = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i - 1] < arr[i]) {
                increase[i] = decrease[i - 1] + 1;
                decrease[i] = 1;
                count = Math.max(count, increase[i]);
            } else if (arr[i - 1] > arr[i]) {
                decrease[i] = increase[i - 1] + 1;
                increase[i] = 1;
                count = Math.max(count, decrease[i]);
            } else {
                increase[i] = 1;
                decrease[i] = 1;
            }
        }
        return count;
    }
}