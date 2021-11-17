> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/unique_paths/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/unique-paths/) 있습니다.

## Problem
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

**Example 1:**

![](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)

```text
Input: m = 3, n = 7
Output: 28
```

**Example 2:**

```text
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
```

**Example 3:**

```text
Input: m = 7, n = 3
Output: 28
```

**Example 4:**

```text
Input: m = 3, n = 3
Output: 6
```

**Constraints:**

* 1 <= m, n <= 100
* It's guaranteed that the answer will be less than or equal to 2 * 10^9.

## Solution

오른쪽과 아래로만 움직일 수 있는 로봇이 존재할 때 오른쪽 아래 코너에 도달할 수 있는 유니크한 경로의 갯수를 반환하는 문제입니다.

전형적인 DP 문제로 점화식만 잘 세우면 아주 간단히 풀 수 있습니다.

우선 전제 조건으로 오른쪽 또는 아래쪽으로만 움직일 수 있기 때문에 첫 번째 행과 열은 무조건 1이 됩니다.

그 이후에는 현재 칸이 위에서 또는 왼쪽에서 움직인 것이므로 두 가지 경우의 수를 합해나가면 됩니다.

```java
public class Solution {

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }
}
```

## Test

```java
package io.lcalmsky.leetcode.unique_paths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenMatrixSize_whenCountUniquePaths_thenCorrect() {
    assertAll(
        () -> test(3, 2, 3),
        () -> test(7, 3, 28)
    );
  }

  private void test(int givenN, int givenM, int expected) {
    // when
    Solution uniquePaths = new Solution();
    int actual = uniquePaths.uniquePaths(givenN, givenM);

    // then
    assertEquals(expected, actual);
  }
}
```