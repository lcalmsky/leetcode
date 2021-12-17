> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/maximal_square/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/maximal-square/) 있습니다.

## Problem

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

**Example 1:**

```text
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
```

**Example 2:**
```text
Input: matrix = [["0","1"],["1","0"]]
Output: 1
```

**Example 3:**
```text
Input: matrix = [["0"]]
Output: 0
```

**Constraints:**

* m == matrix.length
* n == matrix[i].length
* 1 <= m, n <= 300
* matrix[i][j] is '0' or '1'.

## Solution

0과 1로 구성된 m * n 행렬이 주어질 때, 1로만 구성된 가장 큰 정사각형의 면적을 반환하는 문제입니다. 

DP를 이용해 왼쪽, 위쪽, 대각선 왼쪽을 비교해가면서 정사각형의 크기를 구할 수 있습니다.

```java
public class Solution {

  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int width = matrix.length, height = matrix[0].length, result = 0;
    int[][] dp = new int[width][height];
    for (int i = 0; i < width; i++) { // (1)
      dp[i][0] = matrix[i][0] - '0';
      result = Math.max(result, dp[i][0]);
    }
    for (int i = 0; i < height; i++) { // (2)
      dp[0][i] = matrix[0][i] - '0';
      result = Math.max(result, dp[0][i]);
    }
    for (int i = 1; i < width; i++) { // (3)
      for (int j = 1; j < height; j++) {
        if (matrix[i][j] == '0') { // (4)
          dp[i][j] = 0;
          continue;
        }
        // (5)
        int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
        dp[i][j] = min + 1;
        result = Math.max(result, dp[i][j]); // (6)
      }
    }
    return result * result; // (7)
  }
}
```

1. DP 행렬의 첫 행을 초기화 합니다.
2. DP 행렬의 첫 열을 초기화 합니다.
3. 초기화 된 행과 열 이후부터 탐색하면서
4. 0일 경우 아무것도 하지 않습니다.
5. 1일 경우 바로 왼쪽 칸, 위쪽 칸, 대각선 왼쪽 칸의 값의 최솟값을 구해 그 값에 1을 더해줍니다.
6. dp 행렬의 최댓값을 갱신합니다.
7. 최댓값을 제곱해 정사각형의 면적을 반환합니다.

## Test

```java
package io.lcalmsky.leetcode.maximal_square;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenMatrix_whenFindMaximalSquare_thenCorrect() {
    assertAll(
        () -> test(new char[][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        }, 4),
        () -> test(new char[][]{
            {'0', '1'}
        }, 1)
    );
  }

  private void test(char[][] matrix, int expected) {
    // when
    Solution maximalSquare = new Solution();
    int actual = maximalSquare.maximalSquare(matrix);

    // then
    assertEquals(expected, actual);
  }
}
```