package io.lcalmsky.leetcode.array_nesting;

/**
 * <pre>
 * A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 *
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
 * </pre>
 */
public abstract class ArrayNesting {
    public abstract int arrayNesting(int[] nums);
}

class Solution extends ArrayNesting {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                max = Math.max(max, count);
            }
        }
        return max;
    }
}

class AnotherSolution extends ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int next = nums[i], count = 0;
                while (nums[next] != -1) {
                    int previous = next;
                    next = nums[next];
                    count++;
                    nums[previous] = -1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}