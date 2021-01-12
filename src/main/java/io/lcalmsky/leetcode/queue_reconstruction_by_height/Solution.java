package io.lcalmsky.leetcode.queue_reconstruction_by_height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * </pre>
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] array : people) {
            list.add(array[1], array);
        }
        for (int i = 0; i < people.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
