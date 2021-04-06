package io.lcalmsky.leetcode.advantage_shuffle;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < B.length; i++) {
            maxHeap.offer(new int[]{B[i], i});
        }
        int[] result = new int[A.length];
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int[] current = maxHeap.poll();
            result[current[1]] = A[high] > current[0] ? A[high--] : A[low++];
        }
        return result;
    }
}
