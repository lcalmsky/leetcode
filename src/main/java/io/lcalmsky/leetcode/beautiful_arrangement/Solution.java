package io.lcalmsky.leetcode.beautiful_arrangement;

/**
 * <pre>
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
 *
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 *
 *
 * Now given N, how many beautiful arrangements can you construct?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation:
 *
 * The first beautiful arrangement is [1, 2]:
 *
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 *
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 *
 * The second beautiful arrangement is [2, 1]:
 *
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 *
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 *
 *
 * Note:
 *
 * N is a positive integer and will not exceed 15.
 *
 * </pre>
 */
public class Solution {
    private boolean[] used;
    private int result = 0;

    public int countArrangement(int N) {
        used = new boolean[N + 1];
        countArrangement(N, 1); // index starts form 1
        return result;
    }

    private void countArrangement(int N, int index) {
        if (index > N) {
            result++;
            return;
        }

        for (int num = 1; num <= N; num++) {
            if (!used[num] && (num % index == 0 || index % num == 0)) {
                used[num] = true;
                countArrangement(N, index + 1);
                used[num] = false;
            }
        }
    }
}
