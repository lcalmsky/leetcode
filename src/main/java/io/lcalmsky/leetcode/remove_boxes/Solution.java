package io.lcalmsky.leetcode.remove_boxes;

/**
 * DFS + Memory Search
 */
/*
 * <pre>
 * Given several boxes with different colors represented by different positive numbers.
 * You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
 * Find the maximum points you can get.
 *
 * Example 1:
 *
 * Input: boxes = [1,3,2,2,2,3,4,3,1]
 * Output: 23
 * Explanation:
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
 * ----> [1, 3, 3, 3, 1] (1*1=1 points)
 * ----> [1, 1] (3*3=9 points)
 * ----> [] (2*2=4 points)
 *
 *
 * Constraints:
 *
 * 1 <= boxes.length <= 100
 * 1 <= boxes[i] <= 100
 * </pre>
 */
public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] mem = new int[n][n][n];
        return dfs(boxes, mem, 0, n - 1, 0);
    }

    private int dfs(int[] boxes, int[][][] mem, int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        if (mem[left][right][k] != 0) {
            return mem[left][right][k];
        }


        while (right > left && boxes[right] == boxes[right - 1]) {
            right--;
            k++;
        }
        mem[left][right][k] = (k + 1) * (k + 1) + dfs(boxes, mem, left, right - 1, 0);

        // Second Case
        for (int i = left; i < right; i++) {
            if (boxes[i] == boxes[right]) {
                mem[left][right][k] = Math.max(mem[left][right][k],
                        dfs(boxes, mem, i + 1, right - 1, 0) + dfs(boxes, mem, left, i, k + 1));
            }
        }
        return mem[left][right][k];
    }
}

/**
 * DP
 */
class AnotherSolution {
    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int[][][] dp = new int[len][len][len];

        for (int j = 0; j < len; j++) {
            for (int k = 0; k <= j; k++) {
                dp[j][j][k] = (k + 1) * (k + 1);
            }
        }

        for (int l = 1; l < len; l++) {
            for (int j = l; j < len; j++) {
                int i = j - l;

                for (int k = 0; k <= i; k++) {
                    int res = (k + 1) * (k + 1) + dp[i + 1][j][0];

                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] == boxes[i]) {
                            res = Math.max(res, dp[i + 1][m - 1][0] + dp[m][j][k + 1]);
                        }
                    }

                    dp[i][j][k] = res;
                }
            }
        }

        return len == 0 ? 0 : dp[0][len - 1][0];
    }
}
