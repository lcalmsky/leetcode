package io.lcalmsky.leetcode.shortest_subarray_with_sum_at_least_k;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length, result = n + 1;
        int[] accumulated = new int[n + 1];
        for (int i = 0; i < n; i++) accumulated[i + 1] = A[i] + accumulated[i];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (!queue.isEmpty() && accumulated[i] - accumulated[queue.getFirst()] >= K)
                result = Math.min(result, i - queue.pollFirst());
            while (!queue.isEmpty() && accumulated[i] <= accumulated[queue.getLast()])
                queue.pollLast();
            queue.offer(i);
        }
        return result <= n ? result : -1;
    }
}
