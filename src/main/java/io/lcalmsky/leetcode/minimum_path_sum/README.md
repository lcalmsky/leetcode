> 소스 코드는 [여기](https://github.com/lcalmsky/leetcode/blob/master/src/main/java/io/lcalmsky/leetcode/minimum_path_sum/Solution.java) 있습니다.  
> 문제는 [여기](https://leetcode.com/problems/minimum-path-sum/) 있습니다.

## Problem

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.



**Example 1:**

![](https://assets.leetcode.com/uploads/2020/11/05/minpath.jpg)

```
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
```

**Example 2:**

```
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
```

**Constraints:**

* m == grid.length
* n == grid[i].length
* 1 <= m, n <= 200
* 0 <= grid[i][j] <= 200

## Solution

이 문제는 2D 그리드 내에서 왼쪽 위 모서리에서 오른쪽 아래 모서리로 이동하면서 숫자가 적힌 칸을 지날 때, 지나가는 경로의 숫자 합을 최소화하는 문제입니다.

동적 계획법(Dynamic Programming)을 사용하여 문제를 해결할 수 있습니다.

```java
package io.lcalmsky.leetcode.minimum_path_sum;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
```

1. 첫 번째 for 루프: 이 루프는 그리드의 첫 번째 열을 따라 내려가면서 각 칸까지의 최소 경로 합을 계산합니다. 즉, 위에서 아래로 내려오면서 각 칸에 이전 칸까지의 합을 더해줍니다. 이렇게 하면 첫 번째 열의 각 칸에는 해당 칸까지의 최소 경로 합이 계산됩니다.
1. 두 번째 for 루프: 이 루프는 그리드의 첫 번째 행을 따라 오른쪽으로 이동하면서 각 칸까지의 최소 경로 합을 계산합니다. 위와 마찬가지로, 왼쪽에서 오른쪽으로 이동하면서 각 칸에 이전 칸까지의 합을 더해줍니다. 이렇게 하면 첫 번째 행의 각 칸에는 해당 칸까지의 최소 경로 합이 계산됩니다.
1. 세 번째 for 루프: 이 두 개의 중첩된 루프는 그리드의 나머지 부분을 탐색하면서, 각 칸까지의 최소 경로 합을 계산합니다. 각 칸까지의 최소 경로 합은 현재 칸의 값에 왼쪽 칸까지의 최소 경로 합 또는 위쪽 칸까지의 최소 경로 합 중 더 작은 값을 더하여 계산됩니다.
1. 마지막으로, 우측 하단 모서리의 값인 grid[m - 1][n - 1]을 반환하면서 왼쪽 위 모서리에서 오른쪽 아래 모서리로 이동하는 최소 경로 합을 구하게 됩니다.

## Test

```java
package io.lcalmsky.leetcode.minimum_path_sum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    @DisplayName("주어진 grid 에서 왼쪽위부터 오른쪽 아래로 이동하는 경로 중 최소 합 구하기")
    public void givenGrid_whenFindMinimumPath_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                }, 7)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution minimumPathSum = new Solution();
        int actual = minimumPathSum.minPathSum(given);

        // then
        assertEquals(expected, actual);
    }
}
```