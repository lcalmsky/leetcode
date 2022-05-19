> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/longest_increasing_path_in_a_matrix/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) 있습니다.

## Problem

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).



**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/05/grid1.jpg)
```text
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/01/27/tmp-grid.jpg)
```text
Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
```

**Example 3:**

```text
Input: matrix = [[1]]
Output: 1
```

**Constraints:**

* m == matrix.length
* n == matrix[i].length
* 1 <= m, n <= 200
* 0 <= matrix[i][j] <= 2^31 - 1

## Solution

m * n 행렬이 주어질 때 가장 긴 증가하는 경로를 구하는 문제입니다.

각 셀은 상하좌우로만 움직일 수 있고 대각선은 허용되지 않습니다.

DP와 DFS를 이용해 풀 수 있습니다.

```java
public class Solution {

  private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int result = 1;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, dfs(matrix, dp, i, j));
      }
    }
    return result;
  }

  private int dfs(int[][] matrix, int[][] dp, int i, int j) {
    if (dp[i][j] > 0) {
      return dp[i][j];
    }
    int max = 1;
    for (int[] direction : DIRECTIONS) {
      int x = i + direction[0];
      int y = j + direction[1];
      if (!isInBoundary(matrix, x, y) || matrix[x][y] <= matrix[i][j]) {
        continue;
      }
      max = Math.max(max, 1 + dfs(matrix, dp, x, y));
    }
    return dp[i][j] = max;
  }

  private boolean isInBoundary(int[][] matrix, int x, int y) {
    return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
  }
}
```

DP 배열에는 누적된 경로의 길이를 저장합니다.

DFS 방식으로 각 셀마다 이동할 수 있는 경로를 탐색합니다. 

이미 값이 0이 아닌 경우 누적된 길이가 저장되어있으므로 방문했다는 뜻입니다.

각 셀에서 상하좌우로 이동하면서 현재 값보다 더 큰 값을 가진 셀로 이동한 뒤 최댓값을 갱신하여 dp 배열에 할당하고 반환합니다.

이 과정을 반복하면서 결과도 계속 비교하여 최댓값을 구해야 합니다.

## Test

```java
package io.lcalmsky.leetcode.longest_increasing_path_in_a_matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}, 4),
        () -> test(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}, 4),
        () -> test(new int[][]{{1}}, 1)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.longestIncreasingPath(given);
    // then
    assertEquals(expected, actual);
  }
}
```